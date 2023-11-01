package org.main.vistas;

import org.main.Observador;

import javax.swing.*;
import java.awt.*;

/**
 * Vista del retiro del vuelto y del producto luegro de una compra de <code>Expendedor</code>.
 * @see PanelRetiroVuelto
 * @see PanelRetiroProducto
 * @author Askorin
 * @author molivas2022
 */
public class PanelRetiro extends JPanel implements Observador {
    /**
     * Referencia a la vista del retiro del producto.
     */
    private PanelRetiroProducto panelRetiroProducto;
    /**
     * Referencia a la vista del retiro del vuelto.
     */
    private PanelRetiroVuelto panelRetiroVuelto;

    /**
     * Constructor unico.
     * Crea una instancia de <code>PanelRetiroVuelto</code> y de <code>PanelRetiroProducto</code>.
     */
    public PanelRetiro() {
        super();
        setLayout(new GridLayout(1,2));
        panelRetiroProducto = new PanelRetiroProducto();
        panelRetiroVuelto = new PanelRetiroVuelto();
        add(panelRetiroProducto, 0);
        add(panelRetiroVuelto, 1);
    }

    /**
     * Metodo que se llama cuando cambia el estado de los depositos de retiro, para actualizar la vista.
     */
    @Override
    public void cambioModelo() {
        panelRetiroProducto.cambioModelo();
        panelRetiroVuelto.cambioModelo();
    }
}
