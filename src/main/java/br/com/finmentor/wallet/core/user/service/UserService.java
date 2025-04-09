package br.com.finmentor.wallet.core.user.service;

import br.com.finmentor.wallet.core.user.dto.CreateUserDto;
import br.com.finmentor.wallet.core.user.projection.UserDetailedProjection;
import br.com.finmentor.wallet.core.user.usecase.CreateUserUseCase;
import br.com.finmentor.wallet.core.user.usecase.FindUserByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserService {

    private final CreateUserUseCase createUserUseCase;
    private final FindUserByIdUseCase findUserByIdUseCase;

    public void createUser(CreateUserDto dto) {
        createUserUseCase.create(dto);
    }

    public UserDetailedProjection findById(UUID id) {
        return findUserByIdUseCase.findById(id);
    }
}
