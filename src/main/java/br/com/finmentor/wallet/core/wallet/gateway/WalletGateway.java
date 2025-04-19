package br.com.finmentor.wallet.core.wallet.gateway;

import br.com.finmentor.wallet.core.wallet.domain.Wallet;
import br.com.finmentor.wallet.core.wallet.projection.WalletProjection;

import java.util.List;
import java.util.UUID;

public interface WalletGateway {
    void create(Wallet wallet);
    void update(Wallet wallet);
    void deleteBy(UUID id);
    WalletProjection findBy(UUID id);
    List<WalletProjection> findAll(Integer page, Integer size);
}