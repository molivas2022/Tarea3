package org.main;
import org.main.Expendedor;
import org.main.Moneda.*;
import org.main.Producto.Producto;

public class Comprador {
    private String sabor;
    private int vuelto;
    public Comprador(Moneda moneda, int id, Expendedor expendedor) {
        sabor = "nada";
        Producto compra = expendedor.comprarProducto(moneda, id);
        if (compra != null) {
            sabor = compra.consumir();
        }

        vuelto = 0;
        Moneda moneda_vuelto = expendedor.getVuelto();
        while (moneda_vuelto != null) {
            vuelto += moneda_vuelto.getValor();
            moneda_vuelto = expendedor.getVuelto();
        }
    }
    public String queConsumiste() {
        return sabor;
    }
}
