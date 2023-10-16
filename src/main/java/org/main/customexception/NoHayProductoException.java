package org.main.customexception;

public class NoHayProductoException extends Exception {
    public NoHayProductoException(String msg) {
        super(msg);
    }
}
