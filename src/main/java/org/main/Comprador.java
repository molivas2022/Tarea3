package org.main;
import org.main.customexception.NoHayProductoException;
import org.main.customexception.PagoIncorrectoException;
import org.main.customexception.PagoInsuficienteException;
import org.main.moneda.*;
import org.main.producto.Producto;

public class Comprador {
    private String sabor;
    private int vuelto;
    public Comprador(Moneda moneda, int id, Expendedor expendedor)
            throws PagoInsuficienteException,
            PagoIncorrectoException,
            NoHayProductoException
    {
        sabor = "nada";
        /* En esta llamada a comprarProducto podría terminar lanzandose una excepción. */
        Producto compra = expendedor.comprarProducto(moneda, id);
        sabor = compra.consumir();

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

    public int getVuelto() {
        return vuelto;
    }
}
