package br.com.finmentor.wallet.core.asset.service;

import br.com.finmentor.wallet.core.asset.dto.CreateAssetDto;
import br.com.finmentor.wallet.core.asset.dto.UpdateAssetDto;
import br.com.finmentor.wallet.core.asset.projection.AssetDetailedProjection;
import br.com.finmentor.wallet.core.asset.projection.AssetProjection;
import br.com.finmentor.wallet.core.asset.usecase.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AssetService {

    private final CreateAssetUseCase createAssetUseCase;
    private final FindAssetByIdUseCase findAssetByIdUseCase;
    private final FindAllAssetsUseCase findAllAssetsUseCase;
    private final UpdateAssetUseCase updateAssetUseCase;
    private final DeleteAssetUseCase deleteAssetUseCase;

    public void createAsset(CreateAssetDto dto) {
        createAssetUseCase.create(dto);
    }

    public AssetDetailedProjection findById(UUID id) {
        return findAssetByIdUseCase.findById(id);
    }

    public List<AssetProjection> findAll(Integer page, Integer size) {
        return findAllAssetsUseCase.findAll(page, size);
    }

    public void updateAsset(UUID id, UpdateAssetDto dto) {
        updateAssetUseCase.update(dto, id);
    }

    public void deleteAsset(UUID id) {
        deleteAssetUseCase.deleteBy(id);
    }

}
