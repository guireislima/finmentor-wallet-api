package br.com.finmentor.wallet.external_interfaces.database.jpa.wallet_asset.repository;

import br.com.finmentor.wallet.external_interfaces.database.jpa.wallet_asset.entity.WalletAssetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface WalletAssetRepository extends JpaRepository<WalletAssetEntity, UUID> {

    boolean existsByName(String name);

    @Query(value = "SELECT * FROM wallets_assets WHERE wallets_assets.wallet_id = :walletId ORDER BY created_at LIMIT :size OFFSET (SELECT :page * :size)", nativeQuery = true)
    List<WalletAssetEntity> findWalletAssets(UUID walletId, Integer page, Integer size);
}
