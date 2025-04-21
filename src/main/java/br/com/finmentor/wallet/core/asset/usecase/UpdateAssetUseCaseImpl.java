package br.com.finmentor.wallet.core.asset.usecase;

import br.com.finmentor.wallet.core.asset.domain.Asset;
import br.com.finmentor.wallet.core.asset.dto.UpdateAssetDto;
import br.com.finmentor.wallet.core.asset.gateway.AssetGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateAssetUseCaseImpl implements UpdateAssetUseCase {

    private final AssetGateway assetGateway;

    @Override
    public void update(UpdateAssetDto dto, UUID id) {

        Asset asset = new Asset(id, dto.name(), dto.shortName(), dto.currency(), dto.value(), dto.valueBase());

        assetGateway.update(asset);
    }
}
