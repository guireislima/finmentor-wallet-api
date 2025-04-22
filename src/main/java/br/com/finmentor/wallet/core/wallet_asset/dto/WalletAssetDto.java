package br.com.finmentor.wallet.core.wallet_asset.dto;

import java.util.UUID;

public record WalletAssetDto(
        String name,
        UUID assetId,
        Double amount,
        String custody
) {
}
