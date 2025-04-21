package br.com.finmentor.wallet.external_interfaces.database.jpa.asset.repository;

import br.com.finmentor.wallet.core.asset.projection.AssetDetailedProjection;
import br.com.finmentor.wallet.core.asset.projection.AssetProjection;
import br.com.finmentor.wallet.external_interfaces.database.jpa.asset.entity.AssetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AssetRepository extends JpaRepository<AssetEntity, UUID> {

    Optional<AssetEntity> findByName(String name);

    @Query(value = "SELECT * FROM assets WHERE assets.id = :id", nativeQuery = true)
    Optional<AssetDetailedProjection> findByAssetId(UUID id);

    @Query(value = "SELECT * FROM assets ORDER BY name LIMIT :size OFFSET (SELECT :page * :size)", nativeQuery = true)
    List<AssetProjection> findAllAssets(Integer page, Integer size);
}
