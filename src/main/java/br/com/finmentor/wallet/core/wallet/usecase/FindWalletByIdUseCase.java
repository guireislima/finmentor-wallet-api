package br.com.finmentor.wallet.core.wallet.usecase;

import br.com.finmentor.wallet.core.wallet.projection.WalletProjection;

import java.util.UUID;

public interface FindWalletByIdUseCase {
    WalletProjection findById(UUID id);
}
