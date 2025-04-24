package br.com.finmentor.wallet.core.wallet_asset.dto;

import java.util.List;

public record UpdateWalletAssetsDto(
        List<UpdateWalletAssetDto> walletAssets
) {
}
