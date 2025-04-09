package br.com.finmentor.wallet.core.user.projection;

import br.com.finmentor.wallet.core.user.enums.RoleName;

public interface UserProjection {
    String getName();
    String getLogin();
    RoleName getRole();
}
