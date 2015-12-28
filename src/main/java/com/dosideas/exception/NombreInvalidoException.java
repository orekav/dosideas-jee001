/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.exception;

/**
 *
 * @author escuelita
 */
public class NombreInvalidoException extends RuntimeException {

    private static final long serialVersionUID = 1638140290293768761L;
    public NombreInvalidoException(String mensaje) {
        super(mensaje);
    }
}
