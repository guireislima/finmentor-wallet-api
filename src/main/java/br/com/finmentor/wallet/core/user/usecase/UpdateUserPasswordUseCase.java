package br.com.finmentor.wallet.core.user.usecase;

import br.com.finmentor.wallet.core.user.dto.UpdateUserPasswordDto;

import java.util.UUID;

public interface UpdateUserPasswordUseCase {
    void update(UpdateUserPasswordDto dto, UUID id);
}

