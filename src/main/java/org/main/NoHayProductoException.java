package org.main;

public class NoHayProductoException extends RuntimeException {
    private final static String noHayProducto = "Producto solicitado no queda.";
    public NoHayProductoException() {
        super(noHayProducto);
    }
}
