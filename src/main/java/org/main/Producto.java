package org.main;

public abstract class Producto {
    private String serie;

    public Producto(String serie) {
        this.serie = serie;
    }

    abstract public String consumir();

    // TODO(Antonio): Mostrarle a matías lo que es un TODO.
    public String getSerie() {
        return serie;
    }
}
