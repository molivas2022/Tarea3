package org.main.vistas;

import org.main.Controlador;
import org.main.Observador;
import org.main.modelos.productos.Producto;
import org.main.modelos.moneda.Moneda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Vista del deposito de retiro del vuelto de <code>Expendedor</code>.
 * @author Askorin
 * @author molivas2022
 */
public class PanelRetiroVuelto extends JPanel implements Observador {
    /**
     * Constructor unico que crea la vista.
     */
    public PanelRetiroVuelto() {
        super();
        setLayout(new GridLayout(1,2));
        crearAsignarComponentes();
    }

    /**
     * Metodo que se llama cuando cambia el estado del deposito del vuelto.
     * Actualiza la vista.
     */
    public void cambioModelo() {
        this.removeAll();
        this.crearAsignarComponentes();
        this.validate();
    }
    /**
     * Crea la vista del deposito del vuelto y el boton para poder retirarlo moneda por moneda.
     */
    private void crearAsignarComponentes() {
        JPanel panelRetirarVuelto = new JPanel(new BorderLayout());

        Moneda[] monedas = Controlador.verVuelto();
        JPanel panelMonedas = new JPanel(new FlowLayout());
        panelMonedas.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        if (monedas != null) {
            for (int i = 0; i < monedas.length; i++) {
                panelMonedas.add(new PanelMoneda(monedas[i], 48, 48));
            }
        }
        panelRetirarVuelto.add(panelMonedas, BorderLayout.CENTER);

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
