package br.com.finmentor.wallet.core.asset.usecase;

import br.com.finmentor.wallet.core.asset.projection.AssetProjection;

import java.util.List;

public interface FindAllAssetsUseCase {
    List<AssetProjection> findAll(Integer page, Integer size);
}
