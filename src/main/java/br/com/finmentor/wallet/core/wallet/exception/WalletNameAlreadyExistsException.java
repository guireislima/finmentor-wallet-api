package br.com.finmentor.wallet.core.wallet.exception;

public class WalletNameAlreadyExistsException extends RuntimeException {

    public WalletNameAlreadyExistsException(String message) {
        super(message);
    }

}
