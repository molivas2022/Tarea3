package org.main.vistas;
import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    // private PanelComprador pCom;
    private PanelExpendedor pExp;
    private PanelBotones pBot;
    public PanelPrincipal() {
        super();
        pExp = new PanelExpendedor();
        pBot = new PanelBotones();
        setLayout(new GridLayout(1, 0));
        add(pExp);
        add(pBot);
    }
}
