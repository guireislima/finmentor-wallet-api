package br.com.finmentor.wallet.core.wallet_asset.projection;

import java.util.List;

public record WalletAssetsProjection(
        String wallet,
        List<WalletAssetBaseProjection> assets
) {
}
