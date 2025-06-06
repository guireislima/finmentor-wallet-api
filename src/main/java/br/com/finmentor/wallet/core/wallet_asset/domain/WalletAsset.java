package br.com.finmentor.wallet.core.wallet_asset.domain;

import br.com.finmentor.wallet.core.asset.domain.Asset;
import br.com.finmentor.wallet.core.asset.enums.AssetType;
import br.com.finmentor.wallet.core.wallet.domain.Wallet;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class WalletAsset {

    private UUID id;
    private String name;
    private Wallet wallet;
    private Asset asset;
    private Double amount;
    private String custody;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public WalletAsset(String name, Wallet wallet, Asset asset, Double amount, String custody) {
        this.name = name;
        this.wallet = wallet;
        this.asset = asset;
        this.amount = amount;
        this.custody = custody;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public WalletAsset(UUID id, Double amount, String custody) {
        this.id = id;
        this.amount = amount;
        this.custody = custody;
    }

    public static Double getTotal(AssetType type, Double amount, Double value) {
        if (type == AssetType.FIXED_ASSET){
            return amount;
        } else {
            return amount * value;
        }
    }

    public static Double getYield(AssetType type, Double value) {
        if (type == AssetType.FIXED_ASSET){
            return value; // multiply by valueBase, create method in Asset with gateway for financial apis
        } else {
            return value; // subtract by value when createdAt, create method in Asset with gateway for financial apis
        }
    }

}