package br.com.finmentor.wallet.config.exception;

import br.com.finmentor.wallet.core.asset.exception.AssetNameAlreadyExistsException;
import br.com.finmentor.wallet.core.asset.exception.AssetNotFoundException;
import br.com.finmentor.wallet.core.user.exception.UserLoginAlreadyExistsException;
import br.com.finmentor.wallet.core.wallet.exception.WalletNameAlreadyExistsException;
import br.com.finmentor.wallet.core.wallet.exception.WalletNotFoundException;
import br.com.finmentor.wallet.core.wallet_asset.exception.EmptyWalletException;
import br.com.finmentor.wallet.core.wallet_asset.exception.WalletAssetNameAlreadyExistsException;
import br.com.finmentor.wallet.core.wallet_asset.exception.WalletAssetNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MainExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserLoginAlreadyExistsException.class)
    public ResponseEntity<Object> handlerUserLoginAlreadyExistsException(RuntimeException ex, WebRequest request){
        String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(WalletNameAlreadyExistsException.class)
    public ResponseEntity<Object> handlerWalletNameAlreadyExistsException(RuntimeException ex, WebRequest request){
        String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(WalletNotFoundException.class)
    public ResponseEntity<Object> handlerWalletNotFoundException(RuntimeException ex, WebRequest request){
        String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(AssetNameAlreadyExistsException.class)
    public ResponseEntity<Object> handlerAssetNameAlreadyExistsException(RuntimeException ex, WebRequest request){
        String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(AssetNotFoundException.class)
    public ResponseEntity<Object> handlerAssetNotFoundException(RuntimeException ex, WebRequest request){
        String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(EmptyWalletException.class)
    public ResponseEntity<Object> handlerEmptyWalletException(RuntimeException ex, WebRequest request){
        String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(WalletAssetNameAlreadyExistsException.class)
    public ResponseEntity<Object> handlerWalletAssetNameAlreadyExistsException(RuntimeException ex, WebRequest request){
        String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(WalletAssetNotFoundException.class)
    public ResponseEntity<Object> handlerWalletAssetNotFoundException(RuntimeException ex, WebRequest request){
        String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Object> handlerBadCredentialsException(RuntimeException ex, WebRequest request){
        String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<Object> handlerUsernameNotFoundException(RuntimeException ex, WebRequest request){
        String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(AuthorizationDeniedException.class)
    public ResponseEntity<Object> handlerAuthorizationDeniedException(RuntimeException ex, WebRequest request){
        String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
    }
}
