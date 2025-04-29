package br.com.finmentor.wallet.core.asset.dto;

import br.com.finmentor.wallet.core.asset.enums.AssetClass;
import br.com.finmentor.wallet.core.asset.enums.AssetType;
import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateAssetDto(
        String name,
        String shortName,
        AssetType type,
        String currency,
        Double value,
        String valueBase,
        @JsonProperty("class")
        AssetClass assetClass
) {
}
