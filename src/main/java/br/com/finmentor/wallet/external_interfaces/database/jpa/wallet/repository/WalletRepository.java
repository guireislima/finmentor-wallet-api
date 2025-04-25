package br.com.finmentor.wallet.external_interfaces.database.jpa.wallet.repository;

import br.com.finmentor.wallet.core.wallet.projection.WalletProjection;
import br.com.finmentor.wallet.external_interfaces.database.jpa.wallet.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface WalletRepository extends JpaRepository<WalletEntity, UUID> {

    boolean existsByUserIdAndName(UUID userId, String name);

    //@Query(value = "SELECT * FROM wallets WHERE :userId IS NULL OR wallets.user_id = :userId ORDER BY created_at LIMIT :size OFFSET (SELECT :page * :size)", nativeQuery = true)
    @Query(value =
            """
            SELECT w.id,
            	   w.name,
            	   w.created_at,
                   COALESCE(SUM(CASE
            	       	 WHEN a.type = 'FIXED_ASSET' THEN
            	       	   wa.amount
            	       	 ELSE
            	       	   wa.amount * a.value END), 0) sum
              FROM wallets w
              LEFT JOIN wallets_assets wa
                ON w.id = wa.wallet_id
              LEFT JOIN assets a
                ON wa.asset_id = a.id
             WHERE :userId IS NULL OR w.user_id = :userId
            GROUP BY w.id, w.name, w.created_at
            ORDER BY w.created_at LIMIT :size OFFSET (SELECT :page * :size)
            """, nativeQuery = true)
    List<WalletProjection> findAllOrOnlyByUserId(Integer page, Integer size, UUID userId);

    boolean existsByIdAndUserId(UUID id, UUID userId);

    @Query(value =
            """
            SELECT w.id,
            	   w.name,
            	   w.created_at,
                   COALESCE(SUM(CASE
            	       	 WHEN a.type = 'FIXED_ASSET' THEN
            	       	   wa.amount
            	       	 ELSE
            	       	   wa.amount * a.value END), 0) sum
              FROM wallets w
              LEFT JOIN wallets_assets wa
                ON w.id = wa.wallet_id
              LEFT JOIN assets a
                ON wa.asset_id = a.id
             WHERE w.id = :id
            GROUP BY w.id, w.name, w.created_at
            """, nativeQuery = true)
    WalletProjection findWalletById(UUID id);
}
