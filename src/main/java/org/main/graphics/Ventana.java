package org.main.graphics;

import javax.swing.*;
import java.awt.*;

import org.main.modelo.expendedor.Deposito;
import org.main.modelo.moneda.*;

public class Ventana extends JFrame {
    public Ventana() {
        super();
        this.setSize(480, 480);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 16));
        this.setLayout(new GridLayout(2,1));

        Deposito<Moneda> dep = new Deposito<Moneda>();
        dep.addObjeto(new Moneda100());
        dep.addObjeto(new Moneda500());
        dep.addObjeto(new Moneda1000());

        PanelDeposito<Moneda> panel1 = new PanelDeposito<Moneda>(Moneda.class, dep);

        dep = new Deposito<Moneda>();
        dep.addObjeto(new Moneda1500());
        dep.addObjeto(new Moneda1500());

        PanelDeposito<Moneda> panel2 = new PanelDeposito<Moneda>(Moneda.class, dep);

        add(panel1, 0); add(panel2, 1);

        this.setVisible(true);
    }
    public void paint(Graphics g) {
        super.paint(g);
        paintComponents(g);
    }
}
