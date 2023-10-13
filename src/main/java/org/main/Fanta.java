package org.main;

public class Fanta extends Bebida {
    public Fanta(String serie) {
        super(serie);
    }

    @Override
    public String consumir() {
        return "Fanta";
    }
}
