package br.com.finmentor.wallet.external_interfaces.database.jpa.user.entity;

import br.com.finmentor.wallet.core.user.domain.User;
import br.com.finmentor.wallet.core.user.enums.RoleName;
import br.com.finmentor.wallet.external_interfaces.database.jpa.wallet.entity.WalletEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.*;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements UserDetails {

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

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<WalletEntity> wallets = new HashSet<>();

    public UserEntity(String login, String password, String name, String email, RoleName role, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.email = email;
        this.role = role;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    public boolean isLoggedUser(String login) {
        return this.login.equalsIgnoreCase(login);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id);
    }

    public User entityToDomain() {
        return new User(this.id, this.login, this.password, this.name, this.email, this.role, this.createdAt, this.updatedAt, new HashSet<>());
    }

}
