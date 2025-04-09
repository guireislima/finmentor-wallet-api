package br.com.finmentor.wallet.core.user.projection;

import java.time.LocalDateTime;

public interface UserDetailedProjection extends UserProjection {
    String getEmail();
    LocalDateTime getCreatedAt();
}
