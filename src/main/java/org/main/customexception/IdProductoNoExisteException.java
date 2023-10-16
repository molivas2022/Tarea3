package org.main.customexception;

public class IdProductoNoExisteException extends Exception {
    public IdProductoNoExisteException(String msg) {
        super(msg);
    }
}
