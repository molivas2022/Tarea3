package org.main.CustomException;

public class PagoIncorrectoException extends Exception {
    public PagoIncorrectoException() {}
    public PagoIncorrectoException(String msg) {
        super(msg);
    }
}
