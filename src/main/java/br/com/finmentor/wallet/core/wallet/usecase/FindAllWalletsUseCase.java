package br.com.finmentor.wallet.core.wallet.usecase;

import br.com.finmentor.wallet.core.wallet.projection.WalletProjection;

import java.util.List;

public interface FindAllWalletsUseCase {
    List<WalletProjection> findAll(Integer page, Integer size);
}
