package br.com.finmentor.wallet.core.user.usecase;

import br.com.finmentor.wallet.core.user.domain.User;
import br.com.finmentor.wallet.core.user.dto.UpdateUserDto;
import br.com.finmentor.wallet.core.user.gateway.UserGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateUserUseCaseImpl implements UpdateUserUseCase {

    private final UserGateway userGateway;

    @Override
    public void update(UpdateUserDto updateUserDto, UUID userRequestId) {

        User user = new User(userRequestId,
                updateUserDto.name(),
                updateUserDto.email());

        userGateway.update(user);
    }
}
