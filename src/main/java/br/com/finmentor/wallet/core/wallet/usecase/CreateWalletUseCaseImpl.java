package br.com.finmentor.wallet.core.wallet.usecase;

import br.com.finmentor.wallet.core.wallet.domain.Wallet;
import br.com.finmentor.wallet.core.wallet.dto.CreateWalletDto;
import br.com.finmentor.wallet.core.wallet.gateway.WalletGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateWalletUseCaseImpl implements CreateWalletUseCase {

    private final WalletGateway walletGateway;

    @Override
    public void createWallet(CreateWalletDto dto) {

        Wallet wallet = new Wallet(dto.name());

        walletGateway.create(wallet);
    }
}
