package br.com.finmentor.wallet.core.user.usecase;

import br.com.finmentor.wallet.core.user.domain.User;
import br.com.finmentor.wallet.core.user.dto.CreateUserDto;
import br.com.finmentor.wallet.core.user.gateway.UserGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserGateway userGateway;

    @Override
    public void create(CreateUserDto dto) {
        User user = new User(dto.login(),
                dto.password(),
                dto.name(),
                dto.email(),
                dto.role(),
                LocalDateTime.now(),
                LocalDateTime.now());

        userGateway.create(user);
    }
}
