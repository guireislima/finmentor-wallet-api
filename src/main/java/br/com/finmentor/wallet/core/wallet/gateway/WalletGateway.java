package br.com.finmentor.wallet.core.wallet.gateway;

import br.com.finmentor.wallet.core.wallet.domain.Wallet;

import java.util.UUID;

public interface WalletGateway {
    void create(Wallet wallet);
    void update(Wallet wallet);
    void deleteBy(UUID id);
}

