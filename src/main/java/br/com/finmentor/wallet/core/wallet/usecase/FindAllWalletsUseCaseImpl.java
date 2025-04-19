package br.com.finmentor.wallet.core.wallet.usecase;

import br.com.finmentor.wallet.core.wallet.gateway.WalletGateway;
import br.com.finmentor.wallet.core.wallet.projection.WalletProjection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllWalletsUseCaseImpl implements FindAllWalletsUseCase {

    private final WalletGateway walletGateway;

    @Override
    public List<WalletProjection> findAll(Integer page, Integer size) {
        return walletGateway.findAll(page, size);
    }
}
