package br.com.finmentor.wallet.core.wallet_asset.service;

import br.com.finmentor.wallet.core.wallet_asset.dto.WalletAssetDto;
import br.com.finmentor.wallet.core.wallet_asset.projection.WalletAssetsProjection;
import br.com.finmentor.wallet.core.wallet_asset.usecase.AddAssetToWalletUseCase;
import br.com.finmentor.wallet.core.wallet_asset.usecase.ViewWalletAssetsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class WalletAssetService {

    private final AddAssetToWalletUseCase addAssetToWalletUseCase;
    private final ViewWalletAssetsUseCase viewWalletAssetsUseCase;

    public void addAssetToWallet(UUID walletId, WalletAssetDto dto) {
        addAssetToWalletUseCase.add(walletId, dto);
    }

    public WalletAssetsProjection viewWalletAssets(UUID walletId, Integer page, Integer size) {
        return viewWalletAssetsUseCase.view(walletId, page, size);
    }
}
