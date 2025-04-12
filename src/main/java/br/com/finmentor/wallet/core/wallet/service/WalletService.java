package br.com.finmentor.wallet.core.wallet.service;

import br.com.finmentor.wallet.core.wallet.dto.CreateWalletDto;
import br.com.finmentor.wallet.core.wallet.usecase.CreateWalletUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WalletService {

    private final CreateWalletUseCase createWalletUseCase;

    public void createWallet(CreateWalletDto dto) {
        createWalletUseCase.createWallet(dto);
    }
}
