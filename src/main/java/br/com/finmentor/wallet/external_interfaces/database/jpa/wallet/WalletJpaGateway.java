package br.com.finmentor.wallet.external_interfaces.database.jpa.wallet;

import br.com.finmentor.wallet.config.security.service.AuthenticationService;
import br.com.finmentor.wallet.core.wallet.domain.Wallet;
import br.com.finmentor.wallet.core.wallet.exception.WalletNameAlreadyExistsException;
import br.com.finmentor.wallet.core.wallet.gateway.WalletGateway;
import br.com.finmentor.wallet.external_interfaces.database.jpa.wallet.entity.WalletEntity;
import br.com.finmentor.wallet.external_interfaces.database.jpa.wallet.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WalletJpaGateway implements WalletGateway {

    private final AuthenticationService authenticationService;
    private final WalletRepository walletRepository;

    @Override
    public void create(Wallet wallet) {

        UUID userId = authenticationService.getAuthenticatedUserId();

        if (walletRepository.existsByUserIdAndName(userId, wallet.getName())) {
            throw new WalletNameAlreadyExistsException("Wallet name must be unique!");
        }

        WalletEntity walletEntity = new WalletEntity(userId, wallet.getName());

        walletRepository.save(walletEntity);
    }
}
