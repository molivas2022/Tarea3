package org.main;

public enum Catalogo {
    COCACOLA(1600, 1),
    SPRITE(1600, 2),
    FANTA(1600, 3),
    SNICKERS(1200, 4),
    SUPER8(1200, 5);
    private int precio;
    private int id;
    private Catalogo (int precio, int id) {
        this.precio = precio;
        this.id = id;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
