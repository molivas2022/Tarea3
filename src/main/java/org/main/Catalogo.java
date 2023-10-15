package org.main;

public enum Catalogo {
    COCACOLA(1200, 1),
    SPRITE(1200, 2),
    FANTA(1200, 3),
    SNICKERS(800, 4),
    SUPER8(800, 5);
    private int precio;
    private int id;
    Catalogo (int precio, int id) {
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
