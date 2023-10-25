package org.main.vistas;
import org.main.Controlador;
import org.main.Observador;
import org.main.modelos.expendedor.Expendedor;

import javax.swing.*;

public class VentanaApp extends JFrame {
    private final Expendedor exp;
    public VentanaApp(Expendedor exp) {
        super("Expendedor");
        this.exp = exp;
        PanelPrincipal pPrincipal = new PanelPrincipal(exp);

        setContentPane(pPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 640);
        pack();
        setVisible(true);
    }
}
