package org.main.vistas;
import org.main.modelos.expendedor.Expendedor;
import org.main.modelos.productos.CocaCola;
import org.main.modelos.productos.Sprite;

import javax.swing.JPanel;
import java.awt.*;

public class PanelExpendedor extends JPanel {
    private Expendedor exp;
    PanelExpendedor() {
        super();
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(1200, 1200));
        exp = new Expendedor(10);
        PanelDepositoProducto<CocaCola> panelDepCoca = new PanelDepositoProducto<>(exp.getDepCocaCola());
        PanelDepositoProducto<Sprite> panelDepSprite = new PanelDepositoProducto<>(exp.getDepSprite());
        add(panelDepCoca);
        add(panelDepSprite);
    }
}
