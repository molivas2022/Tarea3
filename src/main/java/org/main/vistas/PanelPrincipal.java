package org.main.vistas;
import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    // private PanelComprador pCom;
    private PanelExpendedor pExp;
    public PanelPrincipal() {
        pExp = new PanelExpendedor();
        setLayout(new BorderLayout());
        this.add(pExp);
    }

    public void paint (Graphics g) {
        super.paint(g);
        pExp.paint(g);
    }

}
