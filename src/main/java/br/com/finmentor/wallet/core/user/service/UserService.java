package br.com.finmentor.wallet.core.user.service;

import br.com.finmentor.wallet.core.user.dto.CreateUserDto;
import br.com.finmentor.wallet.core.user.dto.UpdateUserDto;
import br.com.finmentor.wallet.core.user.dto.UpdateUserPasswordDto;
import br.com.finmentor.wallet.core.user.projection.UserDetailedProjection;
import br.com.finmentor.wallet.core.user.projection.UserProjection;
import br.com.finmentor.wallet.core.user.usecase.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserService {

    private final CreateUserUseCase createUserUseCase;
    private final FindUserByIdUseCase findUserByIdUseCase;
    private final FindAllUsersUseCase findAllUsersUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final UpdateUserPasswordUseCase updateUserPasswordUseCase;
    private final DeleteUserUseCase deleteUserUseCase;

    public void createUser(CreateUserDto dto) {
        createUserUseCase.create(dto);
    }

    public UserDetailedProjection findById(UUID id) {
        return findUserByIdUseCase.findById(id);
    }

    public List<UserProjection> findAll(Integer page, Integer size) {
        return findAllUsersUseCase.findAll(page, size);
    }

    public void updateUser(UUID id, UpdateUserDto dto) {
        updateUserUseCase.update(dto, id);
    }

    public void updatePassword(UUID id, UpdateUserPasswordDto dto) {
        updateUserPasswordUseCase.update(dto, id);
    }

    public void deleteUser(UUID id) {
        deleteUserUseCase.deleteBy(id);
    }
}
