package org.main.CustomException;

public class PagoIncorrectoException extends Exception {
    public PagoIncorrectoException(String msg) {
        super(msg);
    }
}
