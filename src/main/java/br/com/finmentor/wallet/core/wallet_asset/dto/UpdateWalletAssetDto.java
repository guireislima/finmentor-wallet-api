package br.com.finmentor.wallet.core.wallet_asset.dto;

import java.util.UUID;

public record UpdateWalletAssetDto(
        UUID id,
        Double amount,
        String custody
) {
}
