package br.com.finmentor.wallet.external_interfaces.database.jpa.wallet;

import br.com.finmentor.wallet.config.security.service.AuthenticationService;
import br.com.finmentor.wallet.core.wallet.domain.Wallet;
import br.com.finmentor.wallet.core.wallet.exception.WalletNameAlreadyExistsException;
import br.com.finmentor.wallet.core.wallet.exception.WalletNotFoundException;
import br.com.finmentor.wallet.core.wallet.gateway.WalletGateway;
import br.com.finmentor.wallet.core.wallet.projection.WalletProjection;
import br.com.finmentor.wallet.external_interfaces.database.jpa.user.entity.UserEntity;
import br.com.finmentor.wallet.external_interfaces.database.jpa.wallet.entity.WalletEntity;
import br.com.finmentor.wallet.external_interfaces.database.jpa.wallet.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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

    @Override
    public void update(Wallet wallet) {

        WalletEntity walletEntity = walletRepository.findById(wallet.getId())
                .orElseThrow(() -> new WalletNotFoundException("Wallet not found!"));

        if (!walletEntity.getUser().equals(authenticationService.getAuthenticatedUser())
                && !authenticationService.isAuthenticatedUserAdmin()) {
            throw new AuthorizationDeniedException("You do not have permission to update this wallet!");
        }

        walletEntity.setName(wallet.getName());
        walletEntity.setUpdatedAt(LocalDateTime.now());

        if (walletRepository.existsByUserIdAndName(walletEntity.getUser().getId(), walletEntity.getName())) {
            throw new WalletNameAlreadyExistsException("Wallet name must be unique!");
        }

        walletRepository.saveAndFlush(walletEntity);

    }

    @Override
    public void deleteBy(UUID id) {

        WalletEntity walletEntity = walletRepository.findById(id)
                .orElseThrow(() -> new WalletNotFoundException("Wallet not found!"));

        if (!walletEntity.getUser().equals(authenticationService.getAuthenticatedUser())
                && !authenticationService.isAuthenticatedUserAdmin()) {
            throw new AuthorizationDeniedException("You do not have permission to delete this wallet!");
        }

        walletRepository.delete(walletEntity);
    }

    @Override
    public WalletProjection findBy(UUID id) {

        if (!walletRepository.existsByIdAndUserId(id, authenticationService.getAuthenticatedUser().getId())
                && !authenticationService.isAuthenticatedUserAdmin()) {
            throw new AuthorizationDeniedException("You do not have permission to access this wallet!");
        }

        return walletRepository.findWalletById(id);
    }

    @Override
    public List<WalletProjection> findAll(Integer page, Integer size) {

        UUID userId = null;
        if (!authenticationService.isAuthenticatedUserAdmin()) {
            userId = authenticationService.getAuthenticatedUser().getId();
        }

        return walletRepository.findAllOrOnlyByUserId(page, size, userId);
    }

}
