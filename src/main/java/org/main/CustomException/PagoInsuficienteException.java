package org.main.CustomException;
public class PagoInsuficienteException extends Exception {
    public PagoInsuficienteException() {}
    public PagoInsuficienteException(String msg) {
        super(msg);
    }
}
