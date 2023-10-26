package org.main.vistas;
import org.main.Observador;
import org.main.modelos.expendedor.Deposito;
import org.main.modelos.expendedor.Expendedor;
import org.main.modelos.productos.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelExpendedor extends JPanel implements Observador {
    private Expendedor exp;
    public PanelExpendedor(Expendedor exp) {
        super();
        this.exp = exp;
        setLayout(new GridLayout(6,1));
        crearAsignarComponentes();
    }
    private void crearAsignarComponentes() {
        for (int i = 0; i < Catalogo.values().length; i++) {
            add( mostrarPanelDepositoProducto(Catalogo.values()[i], 64, 64) );
        }
        JButton botonRelleno = new JButton("Rellenar Expendedor");
        botonRelleno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Hola");
            }
        });
        add(botonRelleno);
    }
    public void cambioModelo() {
        // TODO: DEUDA TENICAAAAA! OJALA NO CREAR EL BOTON DE NUEVO, QUE QUICHE...
        removeAll();
        crearAsignarComponentes();
        /* Esto hace cosas, goooglearloooo, validate() y revalidate() ambos funcan. */
        validate();
        /* no es necesario un repaint y de hecho ni idea de cuándo podría serlo. */
    }
    private <T> JPanel mostrarPanelDepositoProducto(Catalogo PRODUCTO, int width, int height) {
        JPanel panel = new JPanel(new BorderLayout());

        PRODUCTO.getTipo();
        Deposito dep = exp.getDepositoProducto(PRODUCTO);
        PanelDeposito panelDep = new PanelDeposito<>(PRODUCTO.getTipo(), dep, width, height);
        panel.add(panelDep, BorderLayout.CENTER);

        String text = PRODUCTO.getNombre() + ": " + PRODUCTO.precioAsString() + "$";
        JLabel depLabel = new JLabel(text, JLabel.LEFT);
        depLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(depLabel, BorderLayout.PAGE_END);

        return panel;
    }
}
