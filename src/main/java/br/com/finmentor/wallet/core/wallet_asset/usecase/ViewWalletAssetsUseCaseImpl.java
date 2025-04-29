package br.com.finmentor.wallet.core.wallet_asset.usecase;

import br.com.finmentor.wallet.core.asset.domain.Asset;
import br.com.finmentor.wallet.core.wallet_asset.domain.WalletAsset;
import br.com.finmentor.wallet.core.wallet_asset.gateway.WalletAssetGateway;
import br.com.finmentor.wallet.core.wallet_asset.projection.WalletAssetBaseProjection;
import br.com.finmentor.wallet.core.wallet_asset.projection.WalletAssetsProjection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ViewWalletAssetsUseCaseImpl implements ViewWalletAssetsUseCase {

    private final WalletAssetGateway walletAssetGateway;

    @Override
    public WalletAssetsProjection view(UUID walletId, Integer page, Integer size) {

        List<WalletAsset> assets = walletAssetGateway.findAssets(walletId, page, size);

        return new WalletAssetsProjection(assets.get(0).getWallet().getName(),
                assets.stream()
                        .map(wa ->
                        {
                            Asset asset = wa.getAsset();
                            return new WalletAssetBaseProjection(wa.getId(),
                                    asset.getShortName(),
                                    asset.getAssetClass(),
                                    wa.getName(),
                                    wa.getCustody(),
                                    asset.getName(),
                                    asset.getCurrency(),
                                    WalletAsset.getTotal(asset.getType(), wa.getAmount(), asset.getValue()),
                                    WalletAsset.getYield(asset.getType(), asset.getValue()),
                                    wa.getCreatedAt());
                        })
                        .toList());
    }
}
