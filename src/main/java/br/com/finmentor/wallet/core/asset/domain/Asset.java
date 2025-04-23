package br.com.finmentor.wallet.core.asset.domain;

import br.com.finmentor.wallet.core.asset.enums.AssetType;
import br.com.finmentor.wallet.core.wallet_asset.domain.WalletAsset;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class Asset {

    private UUID id;
    private String name;
    private String shortName;
    private AssetType type;
    private String currency;
    private Double value;
    private String valueBase;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Setter
    private Set<WalletAsset> assetWallets = new HashSet<>();

    public Asset(String name, String shortName, AssetType type, String currency, Double value, String valueBase) {
        this.name = name;
        this.shortName = shortName;
        this.type = type;
        this.currency = currency;
        this.value = value;
        this.valueBase = valueBase;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Asset(UUID id, String name, String shortName, String currency, Double value, String valueBase) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.currency = currency;
        this.value = value;
        this.valueBase = valueBase;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Asset(UUID id) {
        this.id = id;
    }
}
