package br.com.finmentor.wallet.core.asset.usecase;

import br.com.finmentor.wallet.core.asset.gateway.AssetGateway;
import br.com.finmentor.wallet.core.asset.projection.AssetProjection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllAssetsUseCaseImpl implements FindAllAssetsUseCase {

    private final AssetGateway assetGateway;

    @Override
    public List<AssetProjection> findAll(Integer page, Integer size) {
        return assetGateway.findAll(page, size);
    }
}
