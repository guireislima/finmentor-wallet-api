package br.com.finmentor.wallet.external_interfaces.database.jpa.asset;

import br.com.finmentor.wallet.config.security.service.AuthenticationService;
import br.com.finmentor.wallet.core.asset.domain.Asset;
import br.com.finmentor.wallet.core.asset.exception.AssetNameAlreadyExistsException;
import br.com.finmentor.wallet.core.asset.exception.AssetNotFoundException;
import br.com.finmentor.wallet.core.asset.gateway.AssetGateway;
import br.com.finmentor.wallet.core.asset.projection.AssetDetailedProjection;
import br.com.finmentor.wallet.core.asset.projection.AssetProjection;
import br.com.finmentor.wallet.external_interfaces.database.jpa.asset.entity.AssetEntity;
import br.com.finmentor.wallet.external_interfaces.database.jpa.asset.repository.AssetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AssetJpaGateway implements AssetGateway {

    private final AssetRepository assetRepository;
    private final AuthenticationService authenticationService;

    @Override
    public void create(Asset asset) {

        if (!authenticationService.isAuthenticatedUserAdmin()) {
            throw new AuthorizationDeniedException("You do not have permission to create an asset!");
        }

        assetRepository.findByName(asset.getName()).ifPresent(found -> {
            throw new AssetNameAlreadyExistsException("Asset name must be unique!");
        });

        AssetEntity assetEntity = new AssetEntity(asset.getName(),
                asset.getShortName(),
                asset.getType(),
                asset.getCurrency(),
                asset.getValue(),
                asset.getValueBase());

        assetRepository.save(assetEntity);
    }

    @Override
    public AssetDetailedProjection findBy(UUID id) {
        return assetRepository.findByAssetId(id)
                .orElseThrow(() -> new AssetNotFoundException("Asset not found!"));
    }

    @Override
    public List<AssetProjection> findAll(Integer page, Integer size) {
        return assetRepository.findAllAssets(page, size);
    }

    @Override
    public void update(Asset asset) {

        if (!authenticationService.isAuthenticatedUserAdmin()) {
            throw new AuthorizationDeniedException("You do not have permission to update an asset!");
        }

        assetRepository.findByName(asset.getName()).ifPresent(found -> {
            throw new AssetNameAlreadyExistsException("Asset name must be unique!");
        });

        AssetEntity assetEntity = assetRepository.findById(asset.getId())
                .orElseThrow(() -> new AssetNotFoundException("Asset not found!"));

        assetEntity.setName(asset.getName());
        assetEntity.setShortName(asset.getShortName());
        assetEntity.setCurrency(asset.getCurrency());
        assetEntity.setValue(asset.getValue());
        assetEntity.setValueBase(asset.getValueBase());

        assetRepository.saveAndFlush(assetEntity);
    }

    @Override
    public void deleteBy(UUID id) {

        if (!authenticationService.isAuthenticatedUserAdmin()) {
            throw new AuthorizationDeniedException("You do not have permission to delete an asset!");
        }

        AssetEntity assetEntity = assetRepository.findById(id)
                .orElseThrow(() -> new AssetNotFoundException("Asset not found!"));

        assetRepository.delete(assetEntity);
    }

}
