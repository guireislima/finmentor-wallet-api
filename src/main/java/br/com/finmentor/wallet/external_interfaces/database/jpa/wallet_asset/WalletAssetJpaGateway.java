package br.com.finmentor.wallet.external_interfaces.database.jpa.wallet_asset;

import br.com.finmentor.wallet.core.wallet_asset.domain.WalletAsset;
import br.com.finmentor.wallet.core.wallet_asset.exception.WalletAssetNameAlreadyExistsException;
import br.com.finmentor.wallet.core.wallet_asset.gateway.WalletAssetGateway;
import br.com.finmentor.wallet.external_interfaces.database.jpa.asset.repository.AssetRepository;
import br.com.finmentor.wallet.external_interfaces.database.jpa.wallet.repository.WalletRepository;
import br.com.finmentor.wallet.external_interfaces.database.jpa.wallet_asset.entity.WalletAssetEntity;
import br.com.finmentor.wallet.external_interfaces.database.jpa.wallet_asset.repository.WalletAssetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletAssetJpaGateway implements WalletAssetGateway {

    private final WalletAssetRepository walletAssetRepository;
    private final WalletRepository walletRepository;
    private final AssetRepository assetRepository;

    @Override
    public void add(WalletAsset walletAsset) {

        if (walletAssetRepository.existsByName(walletAsset.getName())) {
            throw new WalletAssetNameAlreadyExistsException("Wallet asset name must be unique!");
        }

        WalletAssetEntity wae = new WalletAssetEntity(
                walletAsset.getName(),
                walletRepository.findById(walletAsset.getWallet().getId()).get(),
                assetRepository.findById(walletAsset.getAsset().getId()).get(),
                walletAsset.getAmount(),
                walletAsset.getCustody()
        );

        walletAssetRepository.save(wae);

    }
}
