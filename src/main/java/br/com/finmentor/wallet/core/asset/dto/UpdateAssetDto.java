package br.com.finmentor.wallet.core.asset.dto;

public record UpdateAssetDto(
        String name,
        String shortName,
        String currency,
        Double value,
        String valueBase
) {
}
