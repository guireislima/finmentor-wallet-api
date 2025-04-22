package br.com.finmentor.wallet.core.wallet_asset.service;

import br.com.finmentor.wallet.core.wallet_asset.dto.WalletAssetDto;
import br.com.finmentor.wallet.core.wallet_asset.usecase.AddAssetToWalletUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class WalletAssetService {

    private final AddAssetToWalletUseCase addAssetToWalletUseCase;

    public void addAssetToWallet(UUID walletId, WalletAssetDto dto) {
        addAssetToWalletUseCase.add(walletId, dto);
    }

}
