package br.com.finmentor.wallet.core.asset.usecase;

import br.com.finmentor.wallet.core.asset.dto.CreateAssetDto;

public interface CreateAssetUseCase {
    void create(CreateAssetDto dto);
}
