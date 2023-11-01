package org.main.vistas;

import org.main.Controlador;
import org.main.Observador;
import org.main.modelos.productos.Producto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Vista del deposito de retiro del producto comprado de <code>Expendedor</code>.
 * @author Askorin
 * @author molivas2022
 */
public class PanelRetiroProducto extends JPanel implements Observador {
    /**
     * Constructor unico que crea la vista.
     */
    public PanelRetiroProducto() {
        super();
        setLayout(new GridLayout(1,2));
        crearAsignarComponentes();
    }

    /**
     * Metodo que se llama cuando cambia el estado del deposito de retiro del producto comprado.
     * Actualiza la vista.
     */
    public void cambioModelo() {
        this.removeAll();
        this.crearAsignarComponentes();
        this.validate();
    }

    /**
     * Crea la vista del producto comprado y el boton para poder retirarlo.
     */
    private void crearAsignarComponentes() {
        JPanel panelRetirarProducto = new JPanel(new BorderLayout());

        Producto producto = Controlador.verProductoARetirar();
        if (producto != null) {
            JLabel panelProducto = new LabelProducto(producto, 64, 64);
            JPanel centrarPanelProducto = new JPanel(new GridBagLayout());
            centrarPanelProducto.add(panelProducto);
            panelRetirarProducto.add(centrarPanelProducto, BorderLayout.CENTER);
        }

        JButton button = new JButton("Retirar compra");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controlador.retirarProducto();
            }
        });
        panelRetirarProducto.add(button, BorderLayout.PAGE_END);

        add(panelRetirarProducto);
    }
}
