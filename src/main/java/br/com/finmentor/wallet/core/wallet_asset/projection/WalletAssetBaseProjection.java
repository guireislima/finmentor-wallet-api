package br.com.finmentor.wallet.core.wallet_asset.projection;

import br.com.finmentor.wallet.core.asset.enums.AssetClass;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.UUID;

public record WalletAssetBaseProjection(
        UUID id,
        String identifier,
        @JsonProperty("class")
        AssetClass assetClass,
        String name,
        String custody,
        String asset,
        String currency,
        Double total,
        Double yield,
        LocalDateTime acquired
) {
}
