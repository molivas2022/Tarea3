package org.main.graphics;

import org.main.modelo.expendedor.Deposito;
import org.main.modelo.moneda.Moneda;

import javax.swing.*;
import java.awt.*;

public class PanelDeposito<T> extends JPanel {
    private Class<T> type;
    private Deposito<T> deposito;
    public PanelDeposito(Class<T> type, Deposito<T> deposito) {
        super();
        this.type = type;
        this.deposito = deposito;
        setLayout(new FlowLayout(FlowLayout.LEFT));
        for (int i = 0; i < deposito.cuantosObjetos(); i++) {
            JPanel panel = null;
            if (type == Moneda.class) {
                panel = new PanelMoneda((Moneda)deposito.peekObjeto(i), 64, 64);
            }
            add(panel);
        }
    }
    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(0,0,getWidth(),getHeight());
    }
}
