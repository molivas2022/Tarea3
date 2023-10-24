package org.main.vistas;
import org.main.modelos.expendedor.Expendedor;
import org.main.modelos.moneda.Moneda1000;
import org.main.modelos.productos.Catalogo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;

public class PanelBotones extends JPanel {
    public PanelBotones(Expendedor exp) {
        super();

        setLayout(new GridLayout(4,1));
        setBackground(Color.white);
        setPreferredSize(new Dimension(600, 600));

        {
            String[] options = {"CocaCola", "Sprite", "Fanta", "Snickers", "Super8"};
            JPanel ventanaProducto = new SeleccionMultiple("Seleccione que producto desea:", options);
            add(ventanaProducto);
        }   {
            String[] options = {"Moneda de 100 pesos", "Moneda de 500 pesos",
                    "Moneda de 1000 pesos", "Moneda de 1500 pesos"};
            JPanel ventanaProducto = new SeleccionMultiple("Ingrese una moneda:", options);
            add(ventanaProducto);
        }
        add(new JButton("Comprar producto"));

        
        //Parte Antonio
        JButton btnCoca = new JButton("CocaCola");
        add(btnCoca);

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
    class SeleccionMultiple extends JPanel {
        private JRadioButton[] buttons; //TODO: Hay que hacer método getter
        public SeleccionMultiple(String title, String[] options) {
            super();

            buttons = new JRadioButton[options.length];
            ButtonGroup buttongroup = new ButtonGroup();

            JPanel buttonpanel = new JPanel();
            buttonpanel.setLayout(new GridLayout(1, buttons.length));

            for (int i = 0; i < options.length; i++) {
                buttons[i] = new JRadioButton(options[i]);
                buttongroup.add(buttons[i]);
                buttonpanel.add(buttons[i]);
            }

            this.setLayout(new BorderLayout());
            this.add(new Label(title), BorderLayout.PAGE_START);
            this.add(buttonpanel, BorderLayout.CENTER);
        }
    }
}

