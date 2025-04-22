package br.com.finmentor.wallet.core.wallet_asset.usecase;

import br.com.finmentor.wallet.core.asset.domain.Asset;
import br.com.finmentor.wallet.core.asset.gateway.AssetGateway;
import br.com.finmentor.wallet.core.wallet.domain.Wallet;
import br.com.finmentor.wallet.core.wallet.gateway.WalletGateway;
import br.com.finmentor.wallet.core.wallet_asset.domain.WalletAsset;
import br.com.finmentor.wallet.core.wallet_asset.dto.WalletAssetDto;
import br.com.finmentor.wallet.core.wallet_asset.gateway.WalletAssetGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddAssetToWalletUseCaseImpl implements AddAssetToWalletUseCase {

    private final AssetGateway assetGateway;
    private final WalletGateway walletGateway;
    private final WalletAssetGateway walletAssetGateway;

    @Override
    public void add(UUID walletId, WalletAssetDto dto) {

        walletGateway.findBy(walletId);
        assetGateway.findBy(dto.assetId());

        WalletAsset walletAsset = new WalletAsset(dto.name(),
                new Wallet(walletId),
                new Asset(dto.assetId()),
                dto.amount(),
                dto.custody());

        walletAssetGateway.add(walletAsset);
    }
}
