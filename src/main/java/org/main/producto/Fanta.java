package org.main.producto;

public class Fanta extends Bebida {
    public Fanta(String serie) {
        super(serie);
    }

    @Override
    public String consumir() {
        return "Fanta";
    }
}
