package br.com.finmentor.wallet.core.asset.usecase;

import br.com.finmentor.wallet.core.asset.projection.AssetDetailedProjection;

import java.util.UUID;

public interface FindAssetByIdUseCase {
    AssetDetailedProjection findById(UUID id);
}
