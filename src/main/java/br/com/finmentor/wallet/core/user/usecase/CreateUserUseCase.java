package br.com.finmentor.wallet.core.user.usecase;

import br.com.finmentor.wallet.core.user.dto.CreateUserDto;

public interface CreateUserUseCase {
    void create(CreateUserDto dto);
}
