package br.com.finmentor.wallet.external_interfaces.database.jpa.wallet_asset.entity;

import br.com.finmentor.wallet.core.wallet_asset.domain.WalletAsset;
import br.com.finmentor.wallet.external_interfaces.database.jpa.asset.entity.AssetEntity;
import br.com.finmentor.wallet.external_interfaces.database.jpa.wallet.entity.WalletEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Entity
@Table(name = "wallets_assets")
@NoArgsConstructor
@AllArgsConstructor
public class WalletAssetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Setter
    private String name;

    @JoinColumn(name = "wallet_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private WalletEntity wallet;

    @JoinColumn(name = "asset_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private AssetEntity asset;

    @Setter
    private Double amount;

    @Setter
    private String custody;

    @Setter
    private LocalDateTime createdAt;

    @Setter
    private LocalDateTime updatedAt;

    public WalletAssetEntity(String name, WalletEntity wallet, AssetEntity asset, Double amount, String custody) {
        this.name = name;
        this.wallet = wallet;
        this.asset = asset;
        this.amount = amount;
        this.custody = custody;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public WalletAsset entityToDomain() {
        return new WalletAsset(this.id, this.name, this.wallet.entityToDomain(), this.asset.entityToDomain(), this.amount, this.custody, this.createdAt, this.updatedAt);
    }

}
