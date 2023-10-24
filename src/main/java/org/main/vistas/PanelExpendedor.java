package org.main.vistas;
import org.main.modelos.expendedor.Deposito;
import org.main.modelos.expendedor.Expendedor;
import org.main.modelos.moneda.Moneda;
import org.main.modelos.productos.CocaCola;
import org.main.modelos.productos.Producto;
import org.main.modelos.productos.Sprite;

import javax.swing.JPanel;
import java.awt.*;

public class PanelExpendedor extends JPanel {
    private Expendedor exp;
    PanelExpendedor() {
        super();
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setPreferredSize(new Dimension(1200, 1200));
        exp = new Expendedor(5);
        // Crear paneles deposito
        Deposito<CocaCola> cocaDep = exp.getDepCocaCola();
        PanelDeposito<CocaCola> panelCoca = new PanelDeposito<CocaCola>(CocaCola.class, cocaDep);

        add(panelCoca);

    }
}
