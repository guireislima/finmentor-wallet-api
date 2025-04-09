package br.com.finmentor.wallet.core.user.service;

import br.com.finmentor.wallet.core.user.dto.CreateUserDto;
import br.com.finmentor.wallet.core.user.usecase.CreateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserService {

    private final CreateUserUseCase createUserUseCase;

    public void createUser(CreateUserDto dto) {
        createUserUseCase.create(dto);
    }

}
