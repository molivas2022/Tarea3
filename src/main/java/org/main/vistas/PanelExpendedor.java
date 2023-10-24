package org.main.vistas;
import org.main.modelos.expendedor.Expendedor;
import org.main.modelos.moneda.Moneda;
import org.main.modelos.moneda.Moneda100;
import org.main.modelos.moneda.Moneda500;
import org.main.modelos.productos.CocaCola;
import org.main.modelos.productos.Producto;
import org.main.modelos.productos.Sprite;

import javax.swing.JPanel;
import java.awt.*;

public class PanelExpendedor extends JPanel {
    private Expendedor exp;
    public PanelExpendedor() {
        super();
        setLayout(new GridLayout(3,1));
        setPreferredSize(new Dimension(1200, 1200));

        exp = new Expendedor(5);

        // Crear paneles deposito
        // Deposito<CocaCola> cocaDep = exp.getDepCocaCola();
        // PanelDeposito<CocaCola> panelCoca = new PanelDeposito<CocaCola>(CocaCola.class, cocaDep);

        Deposito<Sprite> spriteDep = exp.getDepSprite();
        PanelDeposito<Sprite> panelSprite = new PanelDeposito<Sprite>(Sprite.class, spriteDep);

        Deposito<Moneda> monedaDep = new Deposito<Moneda>();
        monedaDep.addObjeto(new Moneda100()); monedaDep.addObjeto(new Moneda500());
        PanelDeposito<Moneda> panelMoneda = new PanelDeposito<Moneda>(Moneda.class, monedaDep);

        add(panelCoca, 0);
        add(panelSprite, 1);
        add(panelMoneda, 2);
    }
}
