package org.main.vistas;
import org.main.modelos.expendedor.Expendedor;
import org.main.modelos.moneda.Moneda1000;
import org.main.modelos.productos.Catalogo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelBotones extends JPanel {
    public PanelBotones(Expendedor exp) {
        super();
        setLayout(new GridLayout());
        JButton btnCoca = new JButton("CocaCola");
        add(btnCoca);
        setBackground(Color.white);
        setPreferredSize(new Dimension(600, 600));

         btnCoca.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent evt) {
                 // TODO: CÓMO MIERDA MANEJAMOS LA EXCEPCIÓN !?
                 try {
                     // TODO: Se podría usar un controlador o algo?
                     exp.comprarProducto(new Moneda1000(), Catalogo.COCACOLA.getId());
                 } catch (Exception e) {
                     System.err.println(e.getMessage());
                 }
             }
      });
    }
}

