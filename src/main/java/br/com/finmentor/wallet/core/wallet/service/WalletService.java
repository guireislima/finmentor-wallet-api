package br.com.finmentor.wallet.core.wallet.service;

import br.com.finmentor.wallet.core.wallet.dto.CreateWalletDto;
import br.com.finmentor.wallet.core.wallet.dto.UpdateWalletDto;
import br.com.finmentor.wallet.core.wallet.projection.WalletProjection;
import br.com.finmentor.wallet.core.wallet.usecase.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class WalletService {

    private final CreateWalletUseCase createWalletUseCase;
    private final UpdateWalletUseCase updateWalletUseCase;
    private final DeleteWalletUseCase deleteWalletUseCase;
    private final FindWalletByIdUseCase findWalletByIdUseCase;
    private final FindAllWalletsUseCase findAllWalletsUseCase;

    public void createWallet(CreateWalletDto dto) {
        createWalletUseCase.createWallet(dto);
    }

    public void updateWallet(UUID id, UpdateWalletDto dto) {
        updateWalletUseCase.updateWallet(id, dto);
    }

    public void deleteWallet(UUID id) {
        deleteWalletUseCase.deleteWallet(id);
    }

    public WalletProjection findById(UUID id) {
        return findWalletByIdUseCase.findById(id);
    }

    public List<WalletProjection> findAll(Integer page, Integer size) {
        return findAllWalletsUseCase.findAll(page, size);
    }
}
