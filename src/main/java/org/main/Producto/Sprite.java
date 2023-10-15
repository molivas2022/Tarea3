package org.main.Producto;

public class Sprite extends Bebida {
    public Sprite(String serie) {
        super(serie);
    }

    @Override
    public String consumir() {
        return "Sprite";
    }
}
