package org.main;

import org.main.customexception.*;
import org.main.modelos.expendedor.Expendedor;
import org.main.modelos.moneda.Moneda;
import org.main.modelos.productos.Producto;
import org.main.vistas.PanelExcepcion;

public class Controlador {
    private static Expendedor expendedor;
    private static Observador observador;

    public static void comprarProducto(Moneda moneda, int id) {
        try {
            expendedor.comprarProducto(moneda, id);
            observador.cambioModelo();
        } catch (PagoInsuficienteException | NoHayProductoException
                 | IdProductoNoExisteException | PagoIncorrectoException | CompraNoRetiradaException e) {
            PanelExcepcion.imprimir(e);
        }
    }

    public static void setExpendedor(Expendedor expendedor) {
        Controlador.expendedor = expendedor;
    }

    public static void setObservador(Observador observador) {
        Controlador.observador = observador;
    }
}
