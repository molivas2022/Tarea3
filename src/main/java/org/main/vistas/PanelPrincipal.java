package org.main.vistas;
import org.main.Controlador;
import org.main.customexception.IdProductoNoExisteException;
import org.main.customexception.NoHayProductoException;
import org.main.customexception.PagoIncorrectoException;
import org.main.customexception.PagoInsuficienteException;
import org.main.modelos.expendedor.Expendedor;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    // private PanelComprador pCom;
    private PanelExpendedor pExp;
    private PanelBotones pBot;
    public PanelPrincipal(Expendedor exp) {
        super();
        this.pExp = new PanelExpendedor(exp);
        this.pBot = new PanelBotones();
        setLayout(new GridLayout(1, 0));
        add(pExp);
        add(pBot);
    }
}
