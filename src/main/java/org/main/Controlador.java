package org.main;

import org.main.customexception.*;
import org.main.modelos.expendedor.Expendedor;
import org.main.modelos.moneda.Moneda;
import org.main.vistas.PanelExcepcion;
import org.main.modelos.productos.Producto;

public class Controlador {
    private static Expendedor expendedor;
    private static Observador observadorExpendedor;
    private static Observador observadorRetiro;

    public static void comprarProducto(Moneda moneda, int id) {
        try {
            expendedor.comprarProducto(moneda, id);
            observadorExpendedor.cambioModelo();
            observadorRetiro.cambioModelo();
        } catch (PagoInsuficienteException | NoHayProductoException
                 | IdProductoNoExisteException | PagoIncorrectoException | CompraNoRetiradaException e) {
            PanelExcepcion.imprimir(e);
        }
    }
    public static void rellenarExpendedor() {
        expendedor.rellenar();
        observadorExpendedor.cambioModelo();
    }
    public static void retirarProducto() {
        try {
            expendedor.getCompra();
        }
        catch (Exception e) {
            PanelExcepcion.imprimir(e);
        }
        observadorRetiro.cambioModelo();
    }
    public static Producto verProductoARetirar() {
        if (expendedor == null) {return null;}
        return expendedor.peekCompra();
    }

    public static void setExpendedor(Expendedor expendedor) {
        Controlador.expendedor = expendedor;
    }
    public static Expendedor getExpendedor() {
        return Controlador.expendedor;
    }
    public static void setObservadorExpendedor(Observador observador) {
        Controlador.observadorExpendedor = observador;
    }
    public static void setObservadorRetiro(Observador observador) {
        Controlador.observadorRetiro = observador;
    }
}
