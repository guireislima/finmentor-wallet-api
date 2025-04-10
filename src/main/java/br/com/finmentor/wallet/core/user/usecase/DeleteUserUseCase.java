package br.com.finmentor.wallet.core.user.usecase;

import java.util.UUID;

public interface DeleteUserUseCase {
    void deleteBy(UUID id);
}
