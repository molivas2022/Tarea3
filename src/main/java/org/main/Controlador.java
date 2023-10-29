package org.main;

import org.main.customexception.*;
import org.main.modelos.expendedor.Expendedor;
import org.main.modelos.moneda.Moneda;
import org.main.modelos.productos.Catalogo;
import org.main.vistas.PanelExcepcion;
import org.main.modelos.productos.Producto;

public final class Controlador {
    private static Expendedor expendedor;
    private static Observador observadorExpendedor;
    private static Observador observadorRetiro;

    private Controlador() {

    }

    public static void comprarProducto(Moneda moneda, Catalogo producto) {
        try {
            expendedor.comprarProducto(moneda, producto);
            observadorRetiro.cambioModelo();
            observadorExpendedor.cambioModelo();
        } catch (PagoInsuficienteException | NoHayProductoException
                 | ProductoNoExiste | CompraNoRetiradaException e) {
            //Excepciones que devuelven la moneda con que se pagan hacen necesario actualizar el vuelto
            PanelExcepcion.imprimir(e);
            observadorRetiro.cambioModelo();
        } catch (Exception e) {
            PanelExcepcion.imprimir(e);
        }
    }
    public static void rellenarExpendedor() {
        expendedor.rellenar();
        observadorExpendedor.cambioModelo();
    }
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
    public static Producto verProductoARetirar() {
        if (expendedor == null) {return null;}
        return expendedor.peekCompra();
    }
    public static void retirarVuelto() {
        try {
            expendedor.getVuelto();
        }
        catch (Exception e) {
            PanelExcepcion.imprimir(e);
        }
        observadorRetiro.cambioModelo();
    }
    public static Moneda[] verVuelto() {
        if (expendedor == null) {return null;}
        return expendedor.peekVuelto();
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
