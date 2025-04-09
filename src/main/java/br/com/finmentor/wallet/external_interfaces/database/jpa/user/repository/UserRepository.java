package br.com.finmentor.wallet.external_interfaces.database.jpa.user.repository;

import br.com.finmentor.wallet.external_interfaces.database.jpa.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByLogin(String login);
}
