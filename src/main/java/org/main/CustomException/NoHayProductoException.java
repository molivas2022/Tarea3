package org.main.CustomException;

public class NoHayProductoException extends RuntimeException {
    public NoHayProductoException(String msg) {
        super(msg);
    }
}
