package br.com.finmentor.wallet.core.asset.gateway;

import br.com.finmentor.wallet.core.asset.domain.Asset;
import br.com.finmentor.wallet.core.asset.projection.AssetDetailedProjection;
import br.com.finmentor.wallet.core.asset.projection.AssetProjection;

import java.util.List;
import java.util.UUID;

public interface AssetGateway {
    void create(Asset asset);
    AssetDetailedProjection findBy(UUID id);
    List<AssetProjection> findAll(Integer page, Integer size);
    void update(Asset asset);
    void deleteBy(UUID id);
}
