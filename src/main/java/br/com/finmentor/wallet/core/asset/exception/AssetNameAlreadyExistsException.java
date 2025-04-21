package br.com.finmentor.wallet.core.asset.exception;

public class AssetNameAlreadyExistsException extends RuntimeException {

    public AssetNameAlreadyExistsException(String message) {
        super(message);
    }
}
