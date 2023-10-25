package org.main.vistas;
import org.main.Observador;
import org.main.modelos.expendedor.Deposito;
import org.main.modelos.expendedor.Expendedor;
import org.main.modelos.moneda.*;
import org.main.modelos.productos.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelExpendedor extends JPanel implements Observador {
    private Expendedor exp;
    public PanelExpendedor(Expendedor exp) {
        super();
        this.exp = exp;
        setLayout(new GridLayout(6,1));
        crearAsignarPaneles();

        add(new JButton("Rellenar Expendedor"));
    }

    private void crearAsignarPaneles() {
        for (int i = 0; i < Catalogo.values().length; i++) {
            add( mostrarPanelDepositoProducto(Catalogo.values()[i], 64, 64) );
        }
    }
    public void cambioModelo() {
        removeAll();
        crearAsignarPaneles();
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
