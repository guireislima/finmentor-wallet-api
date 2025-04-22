package br.com.finmentor.wallet.core.wallet_asset.gateway;

import br.com.finmentor.wallet.core.wallet_asset.domain.WalletAsset;

public interface WalletAssetGateway {
    void add(WalletAsset walletAsset);
}
