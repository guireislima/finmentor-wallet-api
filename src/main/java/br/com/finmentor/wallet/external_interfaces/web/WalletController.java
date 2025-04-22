package br.com.finmentor.wallet.external_interfaces.web;

import br.com.finmentor.wallet.core.wallet.dto.CreateWalletDto;
import br.com.finmentor.wallet.core.wallet.dto.UpdateWalletDto;
import br.com.finmentor.wallet.core.wallet.projection.WalletProjection;
import br.com.finmentor.wallet.core.wallet.service.WalletService;
import br.com.finmentor.wallet.core.wallet_asset.dto.WalletAssetDto;
import br.com.finmentor.wallet.core.wallet_asset.service.WalletAssetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/wallets")
public class WalletController {

    private WalletService walletService;
    private WalletAssetService walletAssetService;

    @PostMapping
    public ResponseEntity<Void> createWallet(@RequestBody CreateWalletDto dto) {
        walletService.createWallet(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WalletProjection> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(walletService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<WalletProjection>> findAll(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        return ResponseEntity.ok(walletService.findAll(page, size));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateWallet(@PathVariable UUID id, @RequestBody UpdateWalletDto dto) {
        walletService.updateWallet(id, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWallet(@PathVariable UUID id) {
        walletService.deleteWallet(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{walletId}/add")
    public ResponseEntity<Void> addAssetToWallet(@PathVariable UUID walletId, @RequestBody WalletAssetDto dto) {
        walletAssetService.addAssetToWallet(walletId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
