package org.main.vistas;
import org.main.modelos.expendedor.Expendedor;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {

    public PanelPrincipal(Expendedor exp) {
        super();
        setLayout(new GridLayout(1, 0));
        add(new PanelExpendedor(exp));
        add(new PanelBotones());
    }
}
