package org.main;

import org.main.customexception.*;
import org.main.modelos.expendedor.Expendedor;
import org.main.modelos.moneda.Moneda;
import org.main.modelos.productos.Catalogo;
import org.main.vistas.PanelExcepcion;
import org.main.modelos.productos.Producto;

/**
 * Maneja los cambios que se desea hacer al modelo.
 * Permite notificar a las vistas que observan el estado del modelo.
 * @see Observador
 * @author Askorin
 * @author molivas2022
 */
public class Controlador {
    /**
     * Referencia al modelo <code>Expendedor</code>.
     */
    private static Expendedor expendedor;
    /**
     * Vista del <code>Expendedor</code>.
     */
    private static Observador observadorExpendedor;
    /**
     * Vista de la interfaz de los depositos de retiro.
     */
    private static Observador observadorRetiro;

    /**
     * Permite efectuar una compra del <code>Expendedor</code>.
     * @param moneda <code>Moneda</code> con que se efectua la compra.
     * @param producto <code>Producto</code> (del <code>Catalogo</code>) que se quiere comprar.
     */
    public static void comprarProducto(Moneda moneda, Catalogo producto) {
        try {
            expendedor.comprarProducto(moneda, producto);
            observadorRetiro.cambioModelo();
            observadorExpendedor.cambioModelo();
        } catch (PagoInsuficienteException | NoHayProductoException
                 | IdProductoNoExisteException | CompraNoRetiradaException e) {
            //Excepciones que devuelven la moneda con que se pagan hacen necesario actualizar el vuelto
            PanelExcepcion.imprimir(e);
            observadorRetiro.cambioModelo();
        } catch (Exception e) {
            PanelExcepcion.imprimir(e);
        }
    }

    /**
     * Rellena los depositos de productos del <code>Expendedor</code> a su maximo.
     */
    public static void rellenarExpendedor() {
        expendedor.rellenar();
        observadorExpendedor.cambioModelo();
    }

    /**
     * Retira el producto comprado.
     */
    public static void retirarProducto() {
        try {
            Producto compra = expendedor.getCompra();
            System.out.println("Yummy, un(a) " + compra.consumir());
        }
        catch (Exception e) {
            PanelExcepcion.imprimir(e);
        }
        observadorRetiro.cambioModelo();
    }

    /**
     * Permite ver, sin retirar, el producto comprado.
     * @return El producto comprado, disponible para retirar.
     * Devuelve <code>null</code> si no hay producto que retirar.
     */
    public static Producto verProductoARetirar() {
        if (expendedor == null) {return null;}
        return expendedor.peekCompra();
    }

    /**
     * Permite retirar, moneda por moneda, el vuelto.
     */
    public static void retirarVuelto() {
        try {
            expendedor.getVuelto();
        }
        catch (Exception e) {
            PanelExcepcion.imprimir(e);
        }
        observadorRetiro.cambioModelo();
    }

    /**
     * Permite ver todas las monedas de vuelto.
     * @return Array de monedas que hay en el deposito de vuelto.
     */
    public static Moneda[] verVuelto() {
        if (expendedor == null) {return null;}
        return expendedor.peekVuelto();
    }

    /**
     * Establece el <code>Expendedor</code> al cual se van a hacer cambios en su estado.
     * @param expendedor <code>Expendedor</code> que se quiere controlar.
     */
    public static void setExpendedor(Expendedor expendedor) {
        Controlador.expendedor = expendedor;
    }

    /**
     * Devuelve el <code>Expendedor</code> al cual se hacen cambios en su estado.
     * @return <code>Expendedor</code> que se esta controlando.
     */
    public static Expendedor getExpendedor() {
        return Controlador.expendedor;
    }

    /**
     * Establece que <code>Observador</code> ve el estado del Expendedor.
     * @param observador <code>Observador</code> del Expendedor.
     */
    public static void setObservadorExpendedor(Observador observador) {
        Controlador.observadorExpendedor = observador;
    }
    /**
     * Establece que <code>Observador</code> ve el estado de los depositos de retiro del Expendedor.
     * @param observador <code>Observador</code> de los depositos de retiro.
     */
    public static void setObservadorRetiro(Observador observador) {
        Controlador.observadorRetiro = observador;
    }
}
