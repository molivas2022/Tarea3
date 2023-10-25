package org.main.vistas;
import org.main.Controlador;
import org.main.modelos.expendedor.Expendedor;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {

    public PanelPrincipal(Expendedor exp) {
        super();
        setLayout(new GridLayout(1, 0));
        PanelExpendedor pExp = new PanelExpendedor(exp);
        /* PanelExpendedor observará los cambios en vista que notificará Controlador. */
        Controlador.setObservador(pExp);
        add(pExp);
        add(new PanelBotones());
    }
}
