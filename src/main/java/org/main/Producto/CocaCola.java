package org.main.Producto;

public class CocaCola extends Bebida {
    public CocaCola(String serie) {
        super(serie);
    }

    @Override
    public String consumir() {
        return "CocaCola";
    }
}
