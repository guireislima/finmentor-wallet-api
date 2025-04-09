package br.com.finmentor.wallet.core.user.usecase;

import br.com.finmentor.wallet.core.user.gateway.UserGateway;
import br.com.finmentor.wallet.core.user.projection.UserDetailedProjection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class FindUserByIdUseCaseImpl implements FindUserByIdUseCase {

    private final UserGateway userGateway;

    @Override
    public UserDetailedProjection findById(UUID id) {
        return userGateway.findBy(id);
    }
}