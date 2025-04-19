package br.com.finmentor.wallet.external_interfaces.database.jpa.wallet.repository;

import br.com.finmentor.wallet.external_interfaces.database.jpa.wallet.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface WalletRepository extends JpaRepository<WalletEntity, UUID> {

    boolean existsByUserIdAndName(UUID userId, String name);

    @Query(value = "SELECT * FROM wallets WHERE :userId IS NULL OR wallets.user_id = :userId ORDER BY created_at LIMIT :size OFFSET (SELECT :page * :size)", nativeQuery = true)
    List<WalletEntity> findAllOrOnlyByUserId(Integer page, Integer size, UUID userId);
}
