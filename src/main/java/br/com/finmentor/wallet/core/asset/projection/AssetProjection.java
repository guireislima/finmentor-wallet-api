package br.com.finmentor.wallet.core.asset.projection;

public interface AssetProjection {
    String getName();
    String getCurrency();
    Long getValue();
    String getValueBase();
}
