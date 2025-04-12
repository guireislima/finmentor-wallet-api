package br.com.finmentor.wallet.external_interfaces.database.jpa.wallet.repository;

import br.com.finmentor.wallet.external_interfaces.database.jpa.wallet.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WalletRepository extends JpaRepository<WalletEntity, UUID> {
    boolean existsByUserIdAndName(UUID userId, String name);
}
