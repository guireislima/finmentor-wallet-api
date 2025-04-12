package br.com.finmentor.wallet.core.wallet.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class Wallet {

    private UUID id;
    private UUID userId;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Wallet(String name) {
        this.name = name;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

}