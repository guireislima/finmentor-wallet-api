package br.com.finmentor.wallet.core.wallet.usecase;

import br.com.finmentor.wallet.core.wallet.gateway.WalletGateway;
import br.com.finmentor.wallet.core.wallet.projection.WalletProjection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FindWalletByIdUseCaseImpl implements FindWalletByIdUseCase {

    private final WalletGateway walletGateway;

    @Override
    public WalletProjection findById(UUID id) {
        return walletGateway.findBy(id);
    }
}
