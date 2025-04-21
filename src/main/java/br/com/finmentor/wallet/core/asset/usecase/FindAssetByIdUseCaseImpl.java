package br.com.finmentor.wallet.core.asset.usecase;

import br.com.finmentor.wallet.core.asset.gateway.AssetGateway;
import br.com.finmentor.wallet.core.asset.projection.AssetDetailedProjection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FindAssetByIdUseCaseImpl implements FindAssetByIdUseCase {

    private final AssetGateway assetGateway;

    @Override
    public AssetDetailedProjection findById(UUID id) {
        return assetGateway.findBy(id);
    }
}
