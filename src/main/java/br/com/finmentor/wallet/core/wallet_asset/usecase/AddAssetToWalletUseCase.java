package br.com.finmentor.wallet.core.wallet_asset.usecase;

import br.com.finmentor.wallet.core.wallet_asset.dto.CreateWalletAssetDto;

import java.util.UUID;

public interface AddAssetToWalletUseCase {
    void add(UUID walletId, CreateWalletAssetDto dto);
}
