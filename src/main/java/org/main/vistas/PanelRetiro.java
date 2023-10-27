package org.main.vistas;

import org.main.Observador;

import javax.swing.*;
import java.awt.*;

public class PanelRetiro extends JPanel implements Observador {
    private PanelRetiroProducto panelRetiroProducto;
    private PanelRetiroVuelto panelRetiroVuelto;
    public PanelRetiro() {
        super();
        setLayout(new GridLayout(1,2));
        panelRetiroProducto = new PanelRetiroProducto();
        panelRetiroVuelto = new PanelRetiroVuelto();
        add(panelRetiroProducto, 0);
        add(panelRetiroVuelto, 1);
    }

    @Override
    public void cambioModelo() {
        panelRetiroProducto.cambioModelo();
        panelRetiroVuelto.cambioModelo();
    }
}
