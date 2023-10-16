package org.main;
import org.main.customexception.IdProductoNoExiste;
import org.main.customexception.NoHayProductoException;
import org.main.customexception.PagoIncorrectoException;
import org.main.customexception.PagoInsuficienteException;
import org.main.moneda.*;
import org.main.producto.Producto;

public class Comprador {
    private String sabor;
    private int vuelto;
    public Comprador(Moneda moneda, int id, Expendedor expendedor)
            throws PagoIncorrectoException,
            IdProductoNoExiste
    {
        try {
            Producto compra = expendedor.comprarProducto(moneda, id);
            sabor = compra.consumir();
        } catch (PagoInsuficienteException  | NoHayProductoException e) {
            sabor = "nada";
            System.err.println(e.getMessage());
        } finally {
            vuelto = 0;
            /* El comprador extrae el vuelto del expendedor */
            extraerVuelto(expendedor);
        }
    }
    public String queConsumiste() {
        return sabor;
    }
    private void extraerVuelto(Expendedor exp) {
        Moneda moneda_vuelto = exp.getVuelto();
        while (moneda_vuelto != null) {
            vuelto += moneda_vuelto.getValor();
            moneda_vuelto = exp.getVuelto();
        }
    }

    public int getVuelto() {
        return vuelto;
    }
}
