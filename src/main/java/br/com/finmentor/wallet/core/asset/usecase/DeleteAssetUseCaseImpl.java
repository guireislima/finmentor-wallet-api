package br.com.finmentor.wallet.core.asset.usecase;

import br.com.finmentor.wallet.core.asset.gateway.AssetGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteAssetUseCaseImpl implements DeleteAssetUseCase {

    private final AssetGateway assetGateway;

    @Override
    public void deleteBy(UUID id) {
        assetGateway.deleteBy(id);
    }
}
