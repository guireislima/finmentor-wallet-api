package br.com.finmentor.wallet.core.user.usecase;

import br.com.finmentor.wallet.core.user.dto.LoginUserDto;
import br.com.finmentor.wallet.core.user.dto.TokenUserDto;

public interface LoginUseCase {
    TokenUserDto login(LoginUserDto dto);
}

