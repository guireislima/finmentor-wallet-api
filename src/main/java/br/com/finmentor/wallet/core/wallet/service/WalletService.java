package br.com.finmentor.wallet.core.wallet.service;

import br.com.finmentor.wallet.core.wallet.dto.CreateWalletDto;
import br.com.finmentor.wallet.core.wallet.dto.UpdateWalletDto;
import br.com.finmentor.wallet.core.wallet.usecase.CreateWalletUseCase;
import br.com.finmentor.wallet.core.wallet.usecase.DeleteWalletUseCase;
import br.com.finmentor.wallet.core.wallet.usecase.UpdateWalletUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class WalletService {

    private final CreateWalletUseCase createWalletUseCase;
    private final UpdateWalletUseCase updateWalletUseCase;
    private final DeleteWalletUseCase deleteWalletUseCase;

    public void createWallet(CreateWalletDto dto) {
        createWalletUseCase.createWallet(dto);
    }

    public void updateWallet(UUID id, UpdateWalletDto dto) {
        updateWalletUseCase.updateWallet(id, dto);
    }

    public void deleteWallet(UUID id) {
        deleteWalletUseCase.deleteWallet(id);
    }
}
