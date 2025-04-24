package br.com.finmentor.wallet.core.wallet_asset.usecase;

import br.com.finmentor.wallet.core.wallet_asset.gateway.WalletAssetGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteWalletAssetUseCaseImpl implements DeleteWalletAssetUseCase {

    private final WalletAssetGateway walletAssetGateway;

    @Override
    public void delete(UUID walletAssetId) {
        walletAssetGateway.deleteWalletAsset(walletAssetId);
    }
}
