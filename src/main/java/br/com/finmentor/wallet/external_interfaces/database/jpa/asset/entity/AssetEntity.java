package br.com.finmentor.wallet.external_interfaces.database.jpa.asset.entity;

import br.com.finmentor.wallet.core.asset.domain.Asset;
import br.com.finmentor.wallet.core.asset.enums.AssetClass;
import br.com.finmentor.wallet.core.asset.enums.AssetType;
import br.com.finmentor.wallet.external_interfaces.database.jpa.wallet_asset.entity.WalletAssetEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Entity
@Table(name = "assets")
@NoArgsConstructor
@AllArgsConstructor
public class AssetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Setter
    private String name;

    @Setter
    private String shortName;

    @Setter
    @Enumerated(EnumType.STRING)
    private AssetType type;

    @Setter
    private String currency;

    @Setter
    private Double value;

    @Setter
    private String valueBase;

    @Setter
    private LocalDateTime createdAt;

    @Setter
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "asset", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<WalletAssetEntity> assetWallets = new HashSet<>();

    @Setter
    @Enumerated(EnumType.STRING)
    private AssetClass assetClass;

    public AssetEntity(String name, String shortName, AssetType type, String currency, Double value, String valueBase, AssetClass assetClass) {
        this.name = name;
        this.shortName = shortName;
        this.type = type;
        this.currency = currency;
        this.value = value;
        this.valueBase = valueBase;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.assetClass = assetClass;
    }

    public Asset entityToDomain() {
        return new Asset(this.id, this.name, this.shortName, this.type, this.currency, this.value, this.valueBase, this.createdAt, this.updatedAt, this.assetClass, new HashSet<>());
    }

}
