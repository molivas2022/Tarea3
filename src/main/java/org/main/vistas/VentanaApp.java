package org.main.vistas;
import org.main.Observador;
import org.main.modelos.expendedor.Expendedor;

import javax.swing.*;

public class VentanaApp extends JFrame implements Observador {
    private final Expendedor exp;
    public VentanaApp(Expendedor exp) {
        super("Expendedor");
        this.exp = exp;
        setContentPane(new PanelPrincipal(exp));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 640);
        pack();
        setVisible(true);
    }
    public void cambioModelo() {
        /*
         * TODO: Verdaderamente, no es necesario reconstruir el panel principal entero,
         *       solo panelExpendedor, o no?
         */

        /*
         * Se decidió construir un panel nuevo, si bien era posible (y funcionaba)
         * organizar los subpaneles de manera que se pudieran modificar en runtime,
         * esto parece ser más simple y requiere de menos código / complejidad.
         */
        setContentPane(new PanelPrincipal(exp));
        /* Esto hace cosas, goooglearloooo, validate() y revalidate() ambos funcan. */
        validate();
        /* no es necesario un repaint y de hecho ni idea de cuándo podría serlo. */
        // frame.repaint();

    }
}
