package br.com.finmentor.wallet.core.asset.enums;

public enum AssetClass {
    Tesouro("FIXED_ASSET"),
    CDB("FIXED_ASSET"),
    LCI("FIXED_ASSET"),
    LCA("FIXED_ASSET"),
    FundoRF("FIXED_ASSET"),
    Ação("VARIABLE_ASSET"),
    FII("VARIABLE_ASSET"),
    Stock("VARIABLE_ASSET"),
    REIT("VARIABLE_ASSET"),
    Criptomoeda("VARIABLE_ASSET"),
    Multimercado("VARIABLE_ASSET");

    public String type;

    AssetClass(String type) {
        this.type = type;
    }
}
