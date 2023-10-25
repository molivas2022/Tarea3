package org.main;
import org.main.modelos.expendedor.Expendedor;
import org.main.vistas.VentanaApp;
import javax.swing.*;

public class AppExpendedor {

    AppExpendedor() {
        /*
         * TODO: Hacer que hayan más observadores, para poder actualizar views de manera
         *      más targeted
         */

        Expendedor exp = new Expendedor(2);
        VentanaApp frame = new VentanaApp(exp);

        /* Creamos el controlador, su modelo es el expendedor y su vista el frame. */
        Controlador.setExpendedor(exp);
        Controlador.setObservador(frame);
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

