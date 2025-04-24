package br.com.finmentor.wallet.external_interfaces.database.jpa.wallet_asset;

import br.com.finmentor.wallet.config.security.service.AuthenticationService;
import br.com.finmentor.wallet.core.asset.exception.AssetNotFoundException;
import br.com.finmentor.wallet.core.wallet.exception.WalletNotFoundException;
import br.com.finmentor.wallet.core.wallet_asset.domain.WalletAsset;
import br.com.finmentor.wallet.core.wallet_asset.exception.EmptyWalletException;
import br.com.finmentor.wallet.core.wallet_asset.exception.WalletAssetNameAlreadyExistsException;
import br.com.finmentor.wallet.core.wallet_asset.exception.WalletAssetNotFoundException;
import br.com.finmentor.wallet.core.wallet_asset.gateway.WalletAssetGateway;
import br.com.finmentor.wallet.external_interfaces.database.jpa.asset.repository.AssetRepository;
import br.com.finmentor.wallet.external_interfaces.database.jpa.wallet.entity.WalletEntity;
import br.com.finmentor.wallet.external_interfaces.database.jpa.wallet.repository.WalletRepository;
import br.com.finmentor.wallet.external_interfaces.database.jpa.wallet_asset.entity.WalletAssetEntity;
import br.com.finmentor.wallet.external_interfaces.database.jpa.wallet_asset.repository.WalletAssetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WalletAssetJpaGateway implements WalletAssetGateway {

    private final WalletAssetRepository walletAssetRepository;
    private final WalletRepository walletRepository;
    private final AssetRepository assetRepository;
    private final AuthenticationService authenticationService;

    @Override
    public void add(WalletAsset walletAsset) {

        WalletEntity we = walletRepository.findById(walletAsset.getWallet().getId())
                .orElseThrow(() -> new WalletNotFoundException("Wallet not found!"));

        if (!we.getUser().equals(authenticationService.getAuthenticatedUser())
                && !authenticationService.isAuthenticatedUserAdmin()) {
            throw new AuthorizationDeniedException("You do not have permission to access this wallet!");
        }

        if (walletAssetRepository.existsByName(walletAsset.getName())) {
            throw new WalletAssetNameAlreadyExistsException("Name of wallet's asset must be unique!");
        }

        WalletAssetEntity wae = new WalletAssetEntity(
                walletAsset.getName(),
                we,
                assetRepository.findById(walletAsset.getAsset().getId())
                        .orElseThrow(() -> new AssetNotFoundException("Asset not found!")),
                walletAsset.getAmount(),
                walletAsset.getCustody()
        );

        walletAssetRepository.save(wae);

    }

    @Override
    public List<WalletAsset> findAssets(UUID walletId, Integer page, Integer size) {

        List<WalletAssetEntity> assets = walletAssetRepository.findWalletAssets(walletId, page, size);

        if (!assets.isEmpty() && !assets.get(0).getWallet().getUser().equals(authenticationService.getAuthenticatedUser())
                && !authenticationService.isAuthenticatedUserAdmin()) {
            throw new AuthorizationDeniedException("You do not have permission to access this wallet!");
        }

        if (assets.isEmpty()) {
            throw new EmptyWalletException("No assets were found!");
        }

        return assets.stream().map(WalletAssetEntity::entityToDomain).toList();

    }

    @Override
    public void updateWalletAssets(List<WalletAsset> walletAssets) {

        walletAssets.forEach(wa ->
        {
            WalletAssetEntity wae = walletAssetRepository.findById(wa.getId())
                    .orElseThrow(() -> new WalletAssetNotFoundException("Wallet asset not found!"));

            if (!wae.getWallet().getUser().equals(authenticationService.getAuthenticatedUser())
                && !authenticationService.isAuthenticatedUserAdmin()) {
                throw new AuthorizationDeniedException("You do not have permission to access this wallet!");
            }

            wae.setAmount(wa.getAmount());
            wae.setCustody(wa.getCustody());
            wae.setUpdatedAt(LocalDateTime.now());

            walletAssetRepository.saveAndFlush(wae);
        });

    }

    @Override
    public void deleteWalletAsset(UUID walletAssetId) {

        WalletAssetEntity wae = walletAssetRepository.findById(walletAssetId)
                .orElseThrow(() -> new WalletAssetNotFoundException("Wallet asset not found!"));

        if (!wae.getWallet().getUser().equals(authenticationService.getAuthenticatedUser())
                && !authenticationService.isAuthenticatedUserAdmin()) {
            throw new AuthorizationDeniedException("You do not have permission to access this wallet!");
        }

        walletAssetRepository.delete(wae);

    }

}
