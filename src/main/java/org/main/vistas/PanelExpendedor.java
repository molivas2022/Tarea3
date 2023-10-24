package org.main.vistas;
import org.main.modelos.expendedor.Deposito;
import org.main.modelos.expendedor.Expendedor;
import org.main.modelos.moneda.Moneda;
import org.main.modelos.moneda.Moneda100;
import org.main.modelos.moneda.Moneda500;
import org.main.modelos.productos.CocaCola;
import org.main.modelos.productos.Sprite;

import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;

public class PanelExpendedor extends JPanel {
    private Expendedor exp;
    private ArrayList<PanelDeposito<?>> paneles;
    public PanelExpendedor(Expendedor exp) {
        super();
        setLayout(new GridLayout(3,1));
        setPreferredSize(new Dimension(1200, 1200));


        // Crear paneles deposito
        Deposito<CocaCola> cocaDep = exp.getDepCocaCola();
        PanelDeposito<CocaCola> panelCoca = new PanelDeposito<>(CocaCola.class, cocaDep, 64, 120);
        Deposito<Sprite> spriteDep = exp.getDepSprite();
        PanelDeposito<Sprite> panelSprite = new PanelDeposito<>(Sprite.class, spriteDep, 64, 64);

        paneles = new ArrayList<>();

        Deposito<Moneda> monedaDep = new Deposito<>();
        monedaDep.addObjeto(new Moneda100()); monedaDep.addObjeto(new Moneda500());
        PanelDeposito<Moneda> panelMoneda = new PanelDeposito<>(Moneda.class, monedaDep, 64, 64);

        // TODO: Hacer algo con el catálogo de tal manera que haga paneles de depósito para todos los productos.
        paneles.add(panelCoca);
        paneles.add(panelSprite);
        paneles.add(panelMoneda);

        for (JPanel panel : paneles) {
            add(panel);
        }
    }
}
