package org.main.vistas;

import org.main.Controlador;
import org.main.Observador;
import org.main.modelos.productos.Producto;
import org.main.modelos.moneda.Moneda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelRetiroVuelto extends JPanel implements Observador {
    public PanelRetiroVuelto() {
        super();
        setLayout(new GridLayout(1,2));
        crearAsignarComponentes();
    }

    /*
    Metodo que se llama (o deberia llamarse) cuando ocurre un cambio en la parte del modelo
    que esta OBSERVANDO panelRetiro.
    Su contenido es el codigo que permite reflejar dicho cambio.
     */
    public void cambioModelo() {
        this.removeAll();
        this.crearAsignarComponentes();
        this.validate();
    }
    private void crearAsignarComponentes() {
        JPanel panelRetirarVuelto = new JPanel(new BorderLayout());

        Moneda[] monedas = Controlador.verVuelto();
        JPanel panelMonedas = new JPanel(new FlowLayout());
        panelMonedas.setPreferredSize(new Dimension(250,120));
        panelMonedas.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        if (monedas != null) {
            for (int i = 0; i < monedas.length; i++) {
                panelMonedas.add(new PanelMoneda(monedas[i], 48, 48));
            }
        }
        JPanel centrarPanelMonedas = new JPanel(new GridBagLayout());
        centrarPanelMonedas.add(panelMonedas);
        panelRetirarVuelto.add(centrarPanelMonedas, BorderLayout.CENTER);

        JButton button = new JButton("Retirar vuelto");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controlador.retirarVuelto();
            }
        });
        panelRetirarVuelto.add(button, BorderLayout.PAGE_END);

        add(panelRetirarVuelto);
    }
}
