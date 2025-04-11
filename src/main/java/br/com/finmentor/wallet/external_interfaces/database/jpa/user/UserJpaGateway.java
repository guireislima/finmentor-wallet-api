package br.com.finmentor.wallet.external_interfaces.database.jpa.user;

import br.com.finmentor.wallet.config.security.provider.JwtProvider;
import br.com.finmentor.wallet.config.security.service.AuthenticationService;
import br.com.finmentor.wallet.core.user.domain.User;
import br.com.finmentor.wallet.core.user.dto.LoginUserDto;
import br.com.finmentor.wallet.core.user.dto.TokenUserDto;
import br.com.finmentor.wallet.core.user.exception.UserLoginAlreadyExistsException;
import br.com.finmentor.wallet.core.user.gateway.UserGateway;
import br.com.finmentor.wallet.core.user.projection.UserDetailedProjection;
import br.com.finmentor.wallet.core.user.projection.UserProjection;
import br.com.finmentor.wallet.external_interfaces.database.jpa.user.entity.UserEntity;
import br.com.finmentor.wallet.external_interfaces.database.jpa.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserJpaGateway implements UserGateway {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    private final AuthenticationService authenticationService;

    @Override
    @Transactional
    public void create(User user) {

        userRepository.findByLogin(user.getLogin()).ifPresent(found -> {
            throw new UserLoginAlreadyExistsException("User login already exists");
        });

        UserEntity userEntity = new UserEntity(user.getLogin(),
                passwordEncoder.encode(user.getPassword()),
                user.getName(),
                user.getEmail(),
                user.getRole(),
                user.getCreatedAt(),
                user.getUpdatedAt());

        userRepository.save(userEntity);
    }

    @Override
    public UserDetailedProjection findBy(UUID id) {

        UserEntity user = getAdminOrLoggedUser(id);

        return userRepository.findByUserId(user.getId()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public List<UserProjection> findAll(Integer page, Integer size) {

        String login = null;
        if (!authenticationService.isAuthenticatedUserAdmin()) {
            login = authenticationService.getAuthenticatedUserName();
        }

        return userRepository.findAllOrOnlyByLogin(page, size, login);
    }

    @Override
    public void update(User user) {

        UserEntity userEntity = getAdminOrLoggedUser(user.getId());

        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());
        userEntity.setUpdatedAt(LocalDateTime.now());

        userRepository.saveAndFlush(userEntity);
    }

    @Override
    public void updatePassword(User user) {

        UserEntity userEntity = getAdminOrLoggedUser(user.getId());

        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
        userEntity.setUpdatedAt(LocalDateTime.now());

        userRepository.saveAndFlush(userEntity);
    }

    @Override
    public void deleteBy(UUID id) {

        UserEntity userEntity = getAdminOrLoggedUser(id);

        userRepository.delete(userEntity);
    }

    @Override
    public TokenUserDto login(LoginUserDto dto) {

        UserEntity userEntity = userRepository.findByLogin(dto.login()).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        boolean isValidPassword = passwordEncoder.matches(dto.password(), userEntity.getPassword());

        if (!isValidPassword) {
            throw new BadCredentialsException("Invalid password");
        }

        return new TokenUserDto(
                jwtProvider.generateAccessToken(userEntity.getUsername())
        );
    }

    private UserEntity getAdminOrLoggedUser(UUID id) {

        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (authenticationService.isAuthenticatedUserAdmin() || user.isLoggedUser(authenticationService.getAuthenticatedUserName()))
            return user;
        else
            throw new BadCredentialsException("User without permissions");

    }
}