package br.com.finmentor.wallet.core.wallet.usecase;

import br.com.finmentor.wallet.core.wallet.domain.Wallet;
import br.com.finmentor.wallet.core.wallet.dto.UpdateWalletDto;
import br.com.finmentor.wallet.core.wallet.gateway.WalletGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateWalletUseCaseImpl implements UpdateWalletUseCase {

    private final WalletGateway walletGateway;

    @Override
    public void updateWallet(UUID id, UpdateWalletDto dto) {

        Wallet wallet = new Wallet(id, dto.name());

        walletGateway.update(wallet);
    }
}
