package br.com.finmentor.wallet.core.asset.usecase;

import br.com.finmentor.wallet.core.asset.domain.Asset;
import br.com.finmentor.wallet.core.asset.dto.CreateAssetDto;
import br.com.finmentor.wallet.core.asset.gateway.AssetGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateAssetUseCaseImpl implements CreateAssetUseCase {

    private final AssetGateway assetGateway;

    @Override
    public void create(CreateAssetDto dto) {

        Asset asset = new Asset(dto.name(),
                dto.shortName(),
                dto.type(),
                dto.currency(),
                dto.value(),
                dto.valueBase());

        assetGateway.create(asset);

    }
}
