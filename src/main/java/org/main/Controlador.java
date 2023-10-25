package org.main;

import org.main.customexception.IdProductoNoExisteException;
import org.main.customexception.NoHayProductoException;
import org.main.customexception.PagoIncorrectoException;
import org.main.customexception.PagoInsuficienteException;
import org.main.modelos.expendedor.Expendedor;
import org.main.modelos.moneda.Moneda;
import org.main.modelos.productos.Producto;

public class Controlador {
    private static Expendedor expendedor;
    private static Observador observador;

    public static void comprarProducto(Moneda moneda, int id) {
        try {
            Producto compra = expendedor.comprarProducto(moneda, id);
            observador.cambioModelo();
        } catch (PagoInsuficienteException | NoHayProductoException e) {
            System.err.println(e.getMessage());
        } catch (IdProductoNoExisteException e) {
            throw new RuntimeException(e);
        } catch (PagoIncorrectoException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setExpendedor(Expendedor expendedor) {
        Controlador.expendedor = expendedor;
    }

    public static void setObservador(Observador observador) {
        Controlador.observador = observador;
    }
}
