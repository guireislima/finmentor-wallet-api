package br.com.finmentor.wallet.external_interfaces.web;

import br.com.finmentor.wallet.core.user.dto.LoginUserDto;
import br.com.finmentor.wallet.core.user.dto.TokenUserDto;
import br.com.finmentor.wallet.core.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/login")
public class LoginController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<TokenUserDto> login(@RequestBody LoginUserDto dto) {
        return ResponseEntity.ok(userService.login(dto));
    }

}
