package org.main.vistas;
import org.main.modelos.expendedor.Deposito;
import org.main.modelos.expendedor.Expendedor;
import org.main.modelos.moneda.*;
import org.main.modelos.productos.*;

import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;

public class PanelExpendedor extends JPanel {
    public PanelExpendedor(Expendedor exp) {
        super();
        setLayout(new GridLayout(6,1));
        setPreferredSize(new Dimension(1200, 1200));


        // Crear paneles deposito
        //TODO: refactor?
        Deposito<CocaCola> cocaDep = exp.getDepCocaCola();
        PanelDeposito<CocaCola> panelCoca = new PanelDeposito<>(CocaCola.class, cocaDep, 64, 64);
        Deposito<Sprite> spriteDep = exp.getDepSprite();
        PanelDeposito<Sprite> panelSprite = new PanelDeposito<>(Sprite.class, spriteDep, 64, 64);
        Deposito<Fanta> fantaDep = exp.getDepFanta();
        PanelDeposito<Fanta> panelFanta = new PanelDeposito<>(Fanta.class, fantaDep, 64, 64);
        Deposito<Snickers> snickersDep = exp.getDepSnickers();
        PanelDeposito<Snickers> panelSnickers = new PanelDeposito<>(Snickers.class, snickersDep, 64, 64);
        Deposito<Super8> super8Dep = exp.getDepSuper8();
        PanelDeposito<Super8> panelSuper8 = new PanelDeposito<>(Super8.class, super8Dep, 64, 64);


        Deposito<Moneda> monedaDep = new Deposito<>();
        monedaDep.addObjeto(new Moneda100());
        monedaDep.addObjeto(new Moneda500());
        monedaDep.addObjeto(new Moneda1000());
        monedaDep.addObjeto(new Moneda1500());
        PanelDeposito<Moneda> panelMoneda = new PanelDeposito<>(Moneda.class, monedaDep, 64, 64);

        // TODO: Hacer algo con el catálogo de tal manera que haga paneles de depósito para todos los productos.
        ArrayList<PanelDeposito<?>> paneles = new ArrayList<>();
        paneles.add(panelCoca);
        paneles.add(panelSprite);
        paneles.add(panelFanta);
        paneles.add(panelSnickers);
        paneles.add(panelSuper8);
        paneles.add(panelMoneda);

        for (JPanel panel : paneles) {
            add(panel);
        }
    }
}
