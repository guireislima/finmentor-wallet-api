package br.com.finmentor.wallet.core.wallet.gateway;

import br.com.finmentor.wallet.core.wallet.domain.Wallet;

public interface WalletGateway {
    void create(Wallet wallet);
}

