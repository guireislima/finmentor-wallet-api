package br.com.finmentor.wallet.external_interfaces.database.jpa.user;

import br.com.finmentor.wallet.core.user.domain.User;
import br.com.finmentor.wallet.core.user.exception.UserLoginAlreadyExistsException;
import br.com.finmentor.wallet.core.user.gateway.UserGateway;
import br.com.finmentor.wallet.core.user.projection.UserDetailedProjection;
import br.com.finmentor.wallet.core.user.projection.UserProjection;
import br.com.finmentor.wallet.external_interfaces.database.jpa.user.entity.UserEntity;
import br.com.finmentor.wallet.external_interfaces.database.jpa.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserJpaGateway implements UserGateway {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

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
        return userRepository.findByUserId(id).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public List<UserProjection> findAll(Integer page, Integer size) {
        return userRepository.findAll(page, size);
    }
}