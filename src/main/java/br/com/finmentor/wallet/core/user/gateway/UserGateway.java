package br.com.finmentor.wallet.core.user.gateway;

import br.com.finmentor.wallet.core.user.domain.User;

public interface UserGateway {
    void create(User user);
}