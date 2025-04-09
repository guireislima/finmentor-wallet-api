package br.com.finmentor.wallet.core.user.usecase;

import br.com.finmentor.wallet.core.user.projection.UserProjection;

import java.util.List;

public interface FindAllUsersUseCase {
    List<UserProjection> findAll(Integer page, Integer size);
}
