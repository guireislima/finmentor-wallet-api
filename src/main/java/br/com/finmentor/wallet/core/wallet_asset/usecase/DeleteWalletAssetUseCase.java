package br.com.finmentor.wallet.core.wallet_asset.usecase;

import java.util.UUID;

public interface DeleteWalletAssetUseCase {
    void delete(UUID walletAssetId);
}
