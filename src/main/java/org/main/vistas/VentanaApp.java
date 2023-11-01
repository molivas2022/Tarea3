package org.main.vistas;
import org.main.modelos.expendedor.Expendedor;

import javax.swing.*;

/**
 * Clase que inicializa la ventana para la aplicación
 */
public class VentanaApp extends JFrame {
    private final Expendedor exp;

    /**
     * Constructor único para la clase.
     * @param exp El expendedor a ocuparse para la aplicación
     */
    public VentanaApp(Expendedor exp) {
        super("Expendedor");
        this.exp = exp;
        PanelPrincipal pPrincipal = new PanelPrincipal(exp);

        setContentPane(pPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }
}
