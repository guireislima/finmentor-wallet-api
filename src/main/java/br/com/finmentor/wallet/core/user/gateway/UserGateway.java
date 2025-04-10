package br.com.finmentor.wallet.core.user.gateway;

import br.com.finmentor.wallet.core.user.domain.User;
import br.com.finmentor.wallet.core.user.projection.UserDetailedProjection;
import br.com.finmentor.wallet.core.user.projection.UserProjection;

import java.util.List;
import java.util.UUID;

public interface UserGateway {
    void create(User user);
    UserDetailedProjection findBy(UUID id);
    List<UserProjection> findAll(Integer page, Integer size);
    void update(User user);
    void updatePassword(User user);
    void deleteBy(UUID id);
}