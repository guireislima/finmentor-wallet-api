package br.com.finmentor.wallet.core.wallet.usecase;

import br.com.finmentor.wallet.core.wallet.gateway.WalletGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteWalletUseCaseImpl implements DeleteWalletUseCase {

    private final WalletGateway walletGateway;

    @Override
    public void deleteWallet(UUID id) {
        walletGateway.deleteBy(id);
    }
}
