package br.com.finmentor.wallet.core.asset.projection;

import br.com.finmentor.wallet.core.asset.enums.AssetType;

public interface AssetDetailedProjection extends AssetProjection {
    String getShortName();
    AssetType getType();
}
