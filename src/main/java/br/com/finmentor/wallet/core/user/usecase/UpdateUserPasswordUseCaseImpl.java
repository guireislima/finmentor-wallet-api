package br.com.finmentor.wallet.core.user.usecase;

import br.com.finmentor.wallet.core.user.domain.User;
import br.com.finmentor.wallet.core.user.dto.UpdateUserPasswordDto;
import br.com.finmentor.wallet.core.user.gateway.UserGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateUserPasswordUseCaseImpl implements UpdateUserPasswordUseCase {

    private final UserGateway userGateway;

    @Override
    public void update(UpdateUserPasswordDto dto, UUID id) {

        User user = new User(id, dto.password());
        userGateway.updatePassword(user);
    }
}
