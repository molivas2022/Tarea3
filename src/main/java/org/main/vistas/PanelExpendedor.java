package org.main.vistas;
import org.main.modelos.expendedor.Expendedor;


import javax.swing.JPanel;
import java.awt.*;

public class PanelExpendedor extends JPanel {
    private Expendedor exp;
    public PanelExpendedor() {
        super();
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(Color.black);
        setPreferredSize(new Dimension(600, 600));

        exp = new Expendedor(5);

        // Crear paneles deposito
        // Deposito<CocaCola> cocaDep = exp.getDepCocaCola();
        // PanelDeposito<CocaCola> panelCoca = new PanelDeposito<CocaCola>(CocaCola.class, cocaDep);

        // add(panelCoca);

    }
}
