package org.main.vistas;

import org.main.modelos.expendedor.Deposito;
import org.main.modelos.moneda.Moneda;
import org.main.modelos.productos.CocaCola;
import org.main.modelos.productos.Producto;

import javax.swing.*;
import java.awt.*;

public class PanelDeposito<T> extends JPanel {
    private Class<T> type;
    private Deposito<T> deposito;
    int width, height;
    public PanelDeposito(Class<T> type, Deposito<T> deposito, int width, int height) {
        super();
        this.type = type;
        this.deposito = deposito;
        this.width = width;
        this.height = height;
        setLayout(new FlowLayout(FlowLayout.LEFT));
        addComponents();

    }
    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(0,0,getWidth(),getHeight());
    }

    private void addComponents() {
        for (int i = 0; i < deposito.cuantosObjetos(); i++) {
            JPanel panel = null;
            if (type == Moneda.class) {
                panel = new PanelMoneda((Moneda) deposito.peekObjeto(i), width, height);
                add(panel);
            } else if (Producto.class.isAssignableFrom(type)) {
                JLabel label = new PanelProducto((Producto) deposito.peekObjeto(i), width, height);
                add(label);
            }
        }
    }
}
