package br.com.finmentor.wallet.core.user.domain;

import br.com.finmentor.wallet.core.user.enums.RoleName;
import br.com.finmentor.wallet.core.wallet.domain.Wallet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class User {

    private UUID id;
    private String login;
    private String password;
    private String name;
    private String email;
    private RoleName role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Setter
    private Set<Wallet> wallets = new HashSet<>();

    public User(String login, String password, String name, String email, RoleName role, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.email = email;
        this.role = role;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public User(UUID id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public User(UUID id, String password) {
        this.id = id;
        this.password = password;
    }
}