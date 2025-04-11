package br.com.finmentor.wallet.external_interfaces.database.jpa.user.repository;

import br.com.finmentor.wallet.core.user.projection.UserDetailedProjection;
import br.com.finmentor.wallet.core.user.projection.UserProjection;
import br.com.finmentor.wallet.external_interfaces.database.jpa.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SuppressWarnings("all")
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    Optional<UserEntity> findByLogin(String login);

    @Query(value = "SELECT * FROM users WHERE users.id = :id", nativeQuery = true)
    Optional<UserDetailedProjection> findByUserId(UUID id);

    @Query(value = "SELECT * FROM users WHERE :login IS NULL OR users.login = :login ORDER BY name LIMIT :size OFFSET (SELECT :page * :size)", nativeQuery = true)
    List<UserProjection> findAllOrOnlyByLogin(Integer page, Integer size, String login);
}
