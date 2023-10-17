package org.main.comprador;
import org.main.customexception.IdProductoNoExisteException;
import org.main.customexception.NoHayProductoException;
import org.main.customexception.PagoIncorrectoException;
import org.main.customexception.PagoInsuficienteException;
import org.main.expendedor.Expendedor;
import org.main.moneda.*;
import org.main.productos.CocaCola;
import org.main.productos.Fanta;
import org.main.productos.Producto;
import org.main.productos.Sprite;

/**
 * Una clase que entrega las funcionalidades de un Comprador.
 * @author Askorin
 * @author molivas2022
 * @version 1.0.0 17-10-2023
 */
public class Comprador {
    private String sabor;
    private int vuelto;

    /**
     * El método constructor de Comprador. Se realiza la compra dentro de éste.
     * @param moneda La Moneda con la que se desea realizar la compra.
     * @param id El id del producto que se desea comprar, según visto en Catalogo.
     * @param expendedor El Expendedor del cual se va a comprar el producto.
     * @throws PagoIncorrectoException En caso de que la moneda sea <code>null</code>.
     * @throws IdProductoNoExisteException En caso de que el id ingresado no exista en
     * Catalogo
     */
    public Comprador(Moneda moneda, int id, Expendedor expendedor)
            throws PagoIncorrectoException,
            IdProductoNoExisteException
    {
        try {
            Producto compra = expendedor.comprarProducto(moneda, id);
            sabor = compra.consumir();
            vuelto = 0;
            extraerVuelto(expendedor);
        } catch (PagoInsuficienteException  | NoHayProductoException e) {
            sabor = "nada";
            vuelto = 0;
            extraerVuelto(expendedor);
            System.err.println(e.getMessage());
        }
    }

    /**
     * Método que retorna el sabor del producto comprado, si es que existe.
     * @return En caso de una compra exitosa, el sabor del producto comprado;
     * en caso contrario, se retorna <code>"nada"</code>.
     */
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

    /**
     * Método que retorna el vuelto del comprador en caso de ser aplicable.
     * @return El vuelto correspondiente según la compra hecha.
     */
    public int getVuelto() {
        return vuelto;
    }
}
