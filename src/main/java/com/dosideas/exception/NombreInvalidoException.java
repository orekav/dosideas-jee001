package com.dosideas.exception;

public class NombreInvalidoException extends RuntimeException {

    private static final long serialVersionUID = 1638140290293768761L;
    public NombreInvalidoException(String mensaje) {
        super(mensaje);
    }
}
