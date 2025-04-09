package br.com.finmentor.wallet.core.user.usecase;

import br.com.finmentor.wallet.core.user.dto.UpdateUserDto;

import java.util.UUID;

public interface UpdateUserUseCase {
    void update(UpdateUserDto dto, UUID id);
}
