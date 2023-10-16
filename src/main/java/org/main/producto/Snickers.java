package org.main.producto;

public class Snickers extends Dulce {
    public Snickers(String serie) {
        super(serie);
    }

    @Override
    public String consumir() {
        return "Snickers";
    }
}
