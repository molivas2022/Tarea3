package org.main.Producto;

public class Super8 extends Dulce {
    public Super8(String serie) {
        super(serie);
    }

    @Override
    public String consumir() {
        return "Super8";
    }
}
