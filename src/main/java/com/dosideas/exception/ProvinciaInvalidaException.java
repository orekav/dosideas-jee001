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
public class ProvinciaInvalidaException extends RuntimeException {

    private static final long serialVersionUID = 1638140290293768762L;
    public ProvinciaInvalidaException(String mensaje) {
        super(mensaje);
    }
}