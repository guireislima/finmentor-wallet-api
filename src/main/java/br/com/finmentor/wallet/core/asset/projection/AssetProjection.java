package br.com.finmentor.wallet.core.asset.projection;

import java.util.UUID;

public interface AssetProjection {
    UUID getId();
    String getName();
    String getCurrency();
    Long getValue();
    String getValueBase();
}
