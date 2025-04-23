package br.com.finmentor.wallet.core.wallet_asset.usecase;

import br.com.finmentor.wallet.core.wallet_asset.projection.WalletAssetsProjection;

import java.util.UUID;

public interface ViewWalletAssetsUseCase {
    WalletAssetsProjection view(UUID walletId, Integer page, Integer size);
}
