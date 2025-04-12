package br.com.finmentor.wallet.core.wallet.usecase;

import br.com.finmentor.wallet.core.wallet.dto.CreateWalletDto;

public interface CreateWalletUseCase {
    void createWallet(CreateWalletDto dto);
}
