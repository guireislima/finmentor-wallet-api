package br.com.finmentor.wallet.external_interfaces.database.jpa.wallet;

import br.com.finmentor.wallet.config.security.service.AuthenticationService;
import br.com.finmentor.wallet.core.wallet.domain.Wallet;
import br.com.finmentor.wallet.core.wallet.exception.WalletNameAlreadyExistsException;
import br.com.finmentor.wallet.core.wallet.gateway.WalletGateway;
import br.com.finmentor.wallet.external_interfaces.database.jpa.user.entity.UserEntity;
import br.com.finmentor.wallet.external_interfaces.database.jpa.wallet.entity.WalletEntity;
import br.com.finmentor.wallet.external_interfaces.database.jpa.wallet.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletJpaGateway implements WalletGateway {

    private final AuthenticationService authenticationService;
    private final WalletRepository walletRepository;

    @Override
    public void create(Wallet wallet) {

        UserEntity user = authenticationService.getAuthenticatedUser();

        if (walletRepository.existsByUserIdAndName(user.getId(), wallet.getName())) {
            throw new WalletNameAlreadyExistsException("Wallet name must be unique!");
        }

        WalletEntity walletEntity = new WalletEntity(user, wallet.getName());

        walletRepository.save(walletEntity);
    }
}
