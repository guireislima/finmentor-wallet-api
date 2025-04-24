package br.com.finmentor.wallet.core.wallet_asset.projection;

import java.time.LocalDateTime;
import java.util.UUID;

public record WalletAssetBaseProjection(
        UUID id,
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
