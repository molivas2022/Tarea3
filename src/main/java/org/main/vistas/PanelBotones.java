package org.main.vistas;
import org.main.modelos.expendedor.Expendedor;
import org.main.modelos.moneda.Moneda1000;
import org.main.modelos.productos.Catalogo;
import org.main.modelos.moneda.*;

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

        //Selección de Producto
        String[] opcionesProducto = Catalogo.getAllNombres();
        SeleccionMultiple selProducto =
                new SeleccionMultiple("Seleccione que producto desea:", opcionesProducto);
        add(selProducto);

        //Selección de Moneda
        String[] opcionesMoneda = EnumMoneda.getAllNombres();
        SeleccionMultiple selMoneda =
                new SeleccionMultiple("Ingrese una moneda:", opcionesMoneda);
        add(selMoneda);

        //Boton Comprar
        JButton BotonCompra = new JButton("Comprar producto");
        add(BotonCompra);

        BotonCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    // TODO: Se podría usar un controlador o algo?
                    if (selProducto.getSelected() == null) {
                        throw new Exception("Seleccione un producto.");
                    }
                    int idProducto = Catalogo.matchNombre( selProducto.getSelected().getText() ).getId();

                    if (selMoneda.getSelected() == null) {
                        throw new Exception("Seleccione una moneda.");
                    }
                    Moneda monedaSeleccionada = EnumMoneda.matchNombre( selMoneda.getSelected().getText() ).newInstance();

                    exp.comprarProducto(monedaSeleccionada, idProducto);
                } catch (Exception e) {
                    // TODO: CÓMO diantres MANEJAMOS LA EXCEPCIÓN !?
                    System.err.println(e.getMessage());
                }
            }
        });
    }
    class SeleccionMultiple extends JPanel {
        private JRadioButton[] buttons; //TODO: Hay que hacer método getter
        private ButtonGroup buttongroup;
        public SeleccionMultiple(String title, String[] options) {
            super();

            buttons = new JRadioButton[options.length];
            buttongroup = new ButtonGroup();

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
        public JRadioButton getSelected() {
            for (int i = 0; i < buttons.length; i++) {
                if (buttons[i].isSelected()) {
                    return buttons[i];
                }
            }
            return null; //TODO: Una excepción ?
        }
    }
}