package org.main.vistas;

import org.main.Controlador;
import org.main.Observador;
import org.main.modelos.expendedor.Expendedor;
import org.main.modelos.productos.Producto;

import javax.naming.ldap.Control;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelRetiro extends JPanel implements Observador {
    public PanelRetiro() {
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
    public void crearAsignarComponentes() {

        ///Retirar Producto
        JPanel panelRetirarProducto = new JPanel(new BorderLayout());

        Producto producto = Controlador.verProductoARetirar();
        if (producto != null) {
            JLabel panelProducto = new PanelProducto(producto, 64, 64);
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
