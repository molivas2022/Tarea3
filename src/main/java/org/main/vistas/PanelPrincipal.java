package org.main.vistas;
import org.main.Controlador;
import org.main.modelos.expendedor.Expendedor;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que muestra el panel principal de la aplicación
 */
public class PanelPrincipal extends JPanel {

    /**
     * Constructor único para la clase.
     * @param exp El expendedor a ocuparse para la aplicación
     */
    public PanelPrincipal(Expendedor exp) {
        super();
        setLayout(new GridLayout(1, 0));
        PanelExpendedor pExp = new PanelExpendedor(exp);
        /* PanelExpendedor observará los cambios en vista que notificará Controlador. */
        Controlador.setObservadorExpendedor(pExp);
        add(pExp);
        add(new PanelBotones());

    }
}
