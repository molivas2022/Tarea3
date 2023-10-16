package org.main.customexception;

public class PagoIncorrectoException extends Exception {
    public PagoIncorrectoException(String msg) {
        super(msg);
    }
}
