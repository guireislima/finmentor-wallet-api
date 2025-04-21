package br.com.finmentor.wallet.core.asset.dto;

import br.com.finmentor.wallet.core.asset.enums.AssetType;

public record CreateAssetDto(
        String name,
        String shortName,
        AssetType type,
        String currency,
        Double value,
        String valueBase
) {
}
