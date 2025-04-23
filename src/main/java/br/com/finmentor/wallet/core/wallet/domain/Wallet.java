package br.com.finmentor.wallet.core.wallet.domain;

import br.com.finmentor.wallet.core.user.domain.User;
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
public class Wallet {

    private UUID id;
    private User user;
    //private UUID userId;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Setter
    private Set<WalletAsset> walletAssets = new HashSet<>();

    public Wallet(String name) {
        this.name = name;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Wallet(UUID id, String name) {
        this.id = id;
        this.name = name;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Wallet(UUID id) {
        this.id = id;
    }
}