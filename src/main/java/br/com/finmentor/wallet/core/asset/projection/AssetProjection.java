package br.com.finmentor.wallet.core.asset.projection;

import br.com.finmentor.wallet.core.asset.enums.AssetClass;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public interface AssetProjection {
    UUID getId();
    String getName();
    String getCurrency();
    Long getValue();
    String getValueBase();
    @JsonProperty("class")
    AssetClass getAssetClass();
}
