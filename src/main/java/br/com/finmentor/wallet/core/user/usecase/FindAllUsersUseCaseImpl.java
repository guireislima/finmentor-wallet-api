package br.com.finmentor.wallet.core.user.usecase;

import br.com.finmentor.wallet.core.user.gateway.UserGateway;
import br.com.finmentor.wallet.core.user.projection.UserProjection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllUsersUseCaseImpl implements FindAllUsersUseCase {

    private final UserGateway userGateway;

    @Override
    public List<UserProjection> findAll(Integer page, Integer size) {
        return userGateway.findAll(page, size);
    }
}
