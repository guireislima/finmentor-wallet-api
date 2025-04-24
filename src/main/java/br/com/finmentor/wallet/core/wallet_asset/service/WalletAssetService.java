package br.com.finmentor.wallet.core.wallet_asset.service;

import br.com.finmentor.wallet.core.wallet_asset.dto.CreateWalletAssetDto;
import br.com.finmentor.wallet.core.wallet_asset.dto.UpdateWalletAssetsDto;
import br.com.finmentor.wallet.core.wallet_asset.projection.WalletAssetsProjection;
import br.com.finmentor.wallet.core.wallet_asset.usecase.AddAssetToWalletUseCase;
import br.com.finmentor.wallet.core.wallet_asset.usecase.DeleteWalletAssetUseCase;
import br.com.finmentor.wallet.core.wallet_asset.usecase.UpdateWalletAssetsUseCase;
import br.com.finmentor.wallet.core.wallet_asset.usecase.ViewWalletAssetsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class WalletAssetService {

    private final AddAssetToWalletUseCase addAssetToWalletUseCase;
    private final ViewWalletAssetsUseCase viewWalletAssetsUseCase;
    private final UpdateWalletAssetsUseCase updateWalletAssetsUseCase;
    private final DeleteWalletAssetUseCase deleteWalletAssetUseCase;

    public void addAssetToWallet(UUID walletId, CreateWalletAssetDto dto) {
        addAssetToWalletUseCase.add(walletId, dto);
    }

    public WalletAssetsProjection viewWalletAssets(UUID walletId, Integer page, Integer size) {
        return viewWalletAssetsUseCase.view(walletId, page, size);
    }

    public void updateWalletAssets(UpdateWalletAssetsDto dto) {
        updateWalletAssetsUseCase.update(dto);
    }

    public void deleteWalletAsset(UUID walletAssetId) {
        deleteWalletAssetUseCase.delete(walletAssetId);
    }
}
