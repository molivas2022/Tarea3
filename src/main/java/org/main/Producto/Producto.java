package org.main.Producto;

public abstract class Producto {
    private String serie;

    public Producto(String serie) {
        this.serie = serie;
    }

    abstract public String consumir();
    
    public String getSerie() {
        return serie;
    }
}
