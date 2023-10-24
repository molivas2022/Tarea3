package org.main;
import org.main.vistas.PanelPrincipal;
import javax.swing.*;
import java.awt.*;

public class AppExpendedor extends JFrame {

    AppExpendedor() {
        super("Expendedor");
        System.out.println("Hola.");
        setContentPane(new PanelPrincipal());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 640);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        /*
         * Aparentemente es thread-safe correr los códigos den su thread.
         * fuente: www3.ntu.edu.sg/home/ehchua/programming/java/j4a_gui.html#zz-8,
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

