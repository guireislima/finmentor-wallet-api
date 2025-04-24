package br.com.finmentor.wallet.core.wallet_asset.gateway;

import br.com.finmentor.wallet.core.wallet_asset.domain.WalletAsset;

import java.util.List;
import java.util.UUID;

public interface WalletAssetGateway {
    void add(WalletAsset walletAsset);
    List<WalletAsset> findAssets(UUID walletId, Integer page, Integer size);
    void updateWalletAssets(List<WalletAsset> walletAssets);
    void deleteWalletAsset(UUID walletAssetId);
}
