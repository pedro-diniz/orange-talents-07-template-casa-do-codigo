package br.com.zup.desafiocdc.exception;

public class ApiValidationException extends RuntimeException{

    public ApiValidationException(String message) {
        super(message);
    }
}
