package br.com.finmentor.wallet.core.wallet_asset.usecase;

import br.com.finmentor.wallet.core.wallet_asset.domain.WalletAsset;
import br.com.finmentor.wallet.core.wallet_asset.dto.UpdateWalletAssetsDto;
import br.com.finmentor.wallet.core.wallet_asset.gateway.WalletAssetGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UpdateWalletAssetsUseCaseImpl implements UpdateWalletAssetsUseCase {

    private final WalletAssetGateway walletAssetGateway;

    @Override
    public void update(UpdateWalletAssetsDto dto) {

        List<WalletAsset> walletAssets = dto.walletAssets()
                .stream()
                .map(uwad -> new WalletAsset(uwad.id(), uwad.amount(), uwad.custody()))
                .toList();

        walletAssetGateway.updateWalletAssets(walletAssets);
    }
}
