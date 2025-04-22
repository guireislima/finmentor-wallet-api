package br.com.finmentor.wallet.external_interfaces.database.jpa.wallet_asset.repository;

import br.com.finmentor.wallet.external_interfaces.database.jpa.wallet_asset.entity.WalletAssetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WalletAssetRepository extends JpaRepository<WalletAssetEntity, UUID> {

    boolean existsByName(String name);
}
