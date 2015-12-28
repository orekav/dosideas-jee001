package com.dosideas.exception;

public class ProvinciaInvalidaException extends RuntimeException {

    private static final long serialVersionUID = 1638140290293768762L;
    public ProvinciaInvalidaException(String mensaje) {
        super(mensaje);
    }
}