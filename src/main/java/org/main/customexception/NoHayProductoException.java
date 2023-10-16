package org.main.customexception;

public class NoHayProductoException extends RuntimeException {
    public NoHayProductoException(String msg) {
        super(msg);
    }
}
