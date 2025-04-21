package br.com.finmentor.wallet.core.asset.usecase;

import br.com.finmentor.wallet.core.asset.dto.UpdateAssetDto;

import java.util.UUID;

public interface UpdateAssetUseCase {
    void update(UpdateAssetDto dto, UUID id);
}
