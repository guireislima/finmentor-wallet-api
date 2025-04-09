package br.com.finmentor.wallet.core.user.usecase;

import br.com.finmentor.wallet.core.user.projection.UserDetailedProjection;

import java.util.UUID;

public interface FindUserByIdUseCase {
    UserDetailedProjection findById(UUID id);
}
