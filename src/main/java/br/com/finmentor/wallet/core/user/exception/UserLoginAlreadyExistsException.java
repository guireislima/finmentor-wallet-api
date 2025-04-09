package br.com.finmentor.wallet.core.user.exception;

public class UserLoginAlreadyExistsException extends RuntimeException{

    public UserLoginAlreadyExistsException(String message) {
        super(message);
    }

}
