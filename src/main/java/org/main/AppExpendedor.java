package org.main;
import org.main.modelos.expendedor.Expendedor;
import org.main.vistas.VentanaApp;
import javax.swing.*;

/**
 * Aplicacion en su totalidad, incluyendo la parte logica y grafica.
 * @author Askorin
 * @author molivas2022
 */
public final class AppExpendedor {

    /**
     * Inicializa el expendedor, su interfaz grafica, y el controlador.
     */
    private AppExpendedor() {
        // TODO: Manejar excepciónes acá.
        // TODO: Arreglar tests, ver qué hacer con clase Comprador.
        Expendedor exp = new Expendedor();
        VentanaApp frame = new VentanaApp(exp);
        frame.setVisible(true);

        /*
         * Creamos el controlador, su modelo es el expendedor y su vista será
         * PanelExpendedor, que será creado más adelante.
         */
        Controlador.setExpendedor(exp);
    }

    /**
     * Inicia la aplicacion en un mismo hilo.
     */
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

