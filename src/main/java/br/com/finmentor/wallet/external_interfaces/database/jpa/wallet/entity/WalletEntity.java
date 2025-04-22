package br.com.finmentor.wallet.external_interfaces.database.jpa.wallet.entity;

import br.com.finmentor.wallet.external_interfaces.database.jpa.user.entity.UserEntity;
import br.com.finmentor.wallet.external_interfaces.database.jpa.wallet_asset.entity.WalletAssetEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Entity
@Table(name = "wallets")
@NoArgsConstructor
@AllArgsConstructor
public class WalletEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;
    //private UUID userId;

    @Setter
    private String name;

    @Setter
    private LocalDateTime createdAt;

    @Setter
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "wallet", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<WalletAssetEntity> walletAssets = new HashSet<>();

    public WalletEntity(UserEntity user, String name) {
        this.user = user;
        this.name = name;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

}
