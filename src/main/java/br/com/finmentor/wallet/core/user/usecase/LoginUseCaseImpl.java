package br.com.finmentor.wallet.core.user.usecase;

import br.com.finmentor.wallet.core.user.dto.LoginUserDto;
import br.com.finmentor.wallet.core.user.dto.TokenUserDto;
import br.com.finmentor.wallet.core.user.gateway.UserGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginUseCaseImpl implements LoginUseCase {

    private final UserGateway userGateway;

    @Override
    public TokenUserDto login(LoginUserDto dto) {
        return userGateway.login(dto);
    }
}
