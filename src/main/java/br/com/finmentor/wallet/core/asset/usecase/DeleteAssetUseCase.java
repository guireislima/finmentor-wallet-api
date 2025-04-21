package br.com.finmentor.wallet.core.asset.usecase;

import java.util.UUID;

public interface DeleteAssetUseCase {
    void deleteBy(UUID id);
}
