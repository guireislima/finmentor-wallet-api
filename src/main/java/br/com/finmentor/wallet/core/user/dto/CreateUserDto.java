package br.com.finmentor.wallet.core.user.dto;

import br.com.finmentor.wallet.core.user.enums.RoleName;

public record CreateUserDto(
        String login,
        String password,
        String name,
        String email,
        RoleName role
) { }