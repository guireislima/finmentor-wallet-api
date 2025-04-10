package br.com.finmentor.wallet.core.user.usecase;

import br.com.finmentor.wallet.core.user.gateway.UserGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteUserUseCaseImpl implements DeleteUserUseCase {

    private final UserGateway userGateway;

    @Override
    public void deleteBy(UUID id) {
        userGateway.deleteBy(id);
    }
}
