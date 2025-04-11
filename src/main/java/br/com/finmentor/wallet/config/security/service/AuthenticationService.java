package br.com.finmentor.wallet.config.security.service;

import br.com.finmentor.wallet.core.user.enums.RoleName;
import br.com.finmentor.wallet.external_interfaces.database.jpa.user.entity.UserEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean isAuthenticatedUserAdmin() {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
                .anyMatch(ga -> ga.getAuthority().equals(RoleName.ROLE_ADMIN.name()));
    }

    public String getAuthenticatedUserName() {
        return ((UserEntity)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getLogin();
    }
}
