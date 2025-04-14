package br.com.finmentor.wallet.core.wallet.domain;

import br.com.finmentor.wallet.core.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
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

    public Wallet(String name) {
        this.name = name;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

}