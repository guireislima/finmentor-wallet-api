package br.com.finmentor.wallet.core.wallet_asset.usecase;

import br.com.finmentor.wallet.core.wallet_asset.dto.WalletAssetDto;

import java.util.UUID;

public interface AddAssetToWalletUseCase {
    void add(UUID walletId, WalletAssetDto dto);
}
