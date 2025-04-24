package br.com.finmentor.wallet.core.wallet_asset.dto;

import java.util.UUID;

public record CreateWalletAssetDto(
        String name,
        UUID assetId,
        Double amount,
        String custody
) {
}
