package org.main;
import org.main.modelos.expendedor.Expendedor;
import org.main.vistas.VentanaApp;
import javax.swing.*;

public final class AppExpendedor {

    private AppExpendedor() {
        // TODO: Nombres más creativos para ventanas de excepción.
        Expendedor exp = new Expendedor(2);
        VentanaApp frame = new VentanaApp(exp);
        frame.setVisible(true);

        /*
         * Creamos el controlador, su modelo es el expendedor y su vista será
         * PanelExpendedor, que será creado más adelante.
         */
        Controlador.setExpendedor(exp);
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

