package br.com.finmentor.wallet.external_interfaces.web;

import br.com.finmentor.wallet.core.wallet.dto.CreateWalletDto;
import br.com.finmentor.wallet.core.wallet.service.WalletService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/wallets")
public class WalletController {

    private WalletService walletService;

    @PostMapping
    public ResponseEntity<Void> createWallet(@RequestBody CreateWalletDto dto) {
        walletService.createWallet(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
