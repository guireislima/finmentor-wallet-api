package br.com.finmentor.wallet.external_interfaces.database.jpa.user.entity;

import br.com.finmentor.wallet.core.user.enums.RoleName;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String login;

    @Setter
    private String password;

    @Setter
    private String name;

    @Setter
    private String email;

    @Enumerated(EnumType.STRING)
    private RoleName role;

    @Setter
    private LocalDateTime createdAt;

    @Setter
    private LocalDateTime updatedAt;

    public UserEntity(String login, String password, String name, String email, RoleName role, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.email = email;
        this.role = role;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
