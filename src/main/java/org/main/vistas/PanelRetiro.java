package org.main.vistas;

import org.main.Observador;
import org.main.modelos.expendedor.Expendedor;
import org.main.modelos.productos.Catalogo;
import org.main.modelos.productos.Producto;

public class PanelRetiro implements Observador {
    public PanelRetiro(Expendedor exp) {
        Producto compra = exp.getCompra();
        int idProducto = Catalogo.matchNombre(compra.consumir()).getId();
    }

    public void cambioModelo() {

    }
}
