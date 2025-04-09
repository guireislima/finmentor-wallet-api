package br.com.finmentor.wallet.core.user.gateway;

import br.com.finmentor.wallet.core.user.domain.User;
import br.com.finmentor.wallet.core.user.projection.UserDetailedProjection;

import java.util.UUID;

public interface UserGateway {
    void create(User user);
    UserDetailedProjection findBy(UUID id);
}