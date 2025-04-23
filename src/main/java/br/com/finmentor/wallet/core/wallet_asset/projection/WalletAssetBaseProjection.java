package br.com.finmentor.wallet.core.wallet_asset.projection;

import java.time.LocalDateTime;

public record WalletAssetBaseProjection(
        String identifier,
        String name,
        String custody,
        String asset,
        String currency,
        Double total,
        Double yield,
        LocalDateTime acquired
) {
}
