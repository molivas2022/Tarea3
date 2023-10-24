package org.main;
import org.main.modelos.expendedor.Expendedor;
import org.main.modelos.moneda.Moneda1000;
import org.main.modelos.productos.Catalogo;
import org.main.vistas.PanelPrincipal;
import javax.swing.*;
import java.awt.*;

public class AppExpendedor implements Observador {

    final private JFrame frame;
    final private Expendedor exp = new Expendedor(2, this);

    AppExpendedor() {
        frame = new JFrame("Expendedor");
        /* Creamos el expendedor (Modelo) y le damos la referencia al Controlador. */
        frame.setContentPane(new PanelPrincipal(exp));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 640);
        frame.pack();
        frame.setVisible(true);
    }

    public void cambioModelo() {
        /*
         * TODO: Verdaderamente, no es necesario reconstruir el panel principal entero,
         *       solo panelExpendedor, o no?
         */

        /*
         * Se decidió construir un panel nuevo, si bien era posible (y funcionaba)
         * organizar los subpaneles de manera que se pudieran modificar en runtime,
         * esto parece ser más simple y requiere de menos implmenetación / complejidad.
         */
        frame.setContentPane(new PanelPrincipal(exp));
        /* Esto hace cosas, goooglearloooo, validate() y revalidate() ambos funcan. */
        frame.validate();
        /* no es necesario un repaint y de hecho ni idea de cuándo podría serlo. */
        // frame.repaint();
    }

    public static void main(String[] args) {
        /*
         * Aparentemente es thread-safe correr los códigos en su thread.
         * fuente: www3.ntu.edu.sg/home/ehchua/programming/java/j4a_gui.html#zz-8
         * capítulo 8.4
         */
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AppExpendedor();
            }
        });
    }
}

