package br.com.finmentor.wallet.core.wallet.usecase;

import br.com.finmentor.wallet.core.wallet.dto.UpdateWalletDto;

import java.util.UUID;

public interface UpdateWalletUseCase {
    void updateWallet(UUID id, UpdateWalletDto dto);
}
