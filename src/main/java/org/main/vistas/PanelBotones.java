package org.main.vistas;
import org.main.Controlador;
import org.main.modelos.expendedor.Expendedor;
import org.main.modelos.productos.Catalogo;
import org.main.modelos.moneda.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                new SeleccionMultiple("Ingrese una moneda:", opcionesMoneda, new GridLayout(2,2));

        //Ventana de Moneda
        JPanel venMoneda = new JPanel();
        venMoneda.setLayout(new GridLayout(1,2));
        venMoneda.add(selMoneda, 0);

        add(venMoneda);

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

                    Controlador.comprarProducto(monedaSeleccionada, idProducto);

                } catch (Exception e) {
                    PanelExcepcion.imprimir(e);
                }
            }
        });

        //Botones Seleccion Moneda
        for (JRadioButton b: selMoneda.getButtons()) {
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("el pepe");
                    //Previsualización de selección de Moneda
                    if (selMoneda.getSelected() != null) {
                        Moneda preMoneda = EnumMoneda.matchNombre(selMoneda.getSelected().getText()).newInstance();
                        PanelMoneda panelPreMoneda = new PanelMoneda(preMoneda, 64, 64);
                        venMoneda.removeAll();
                        venMoneda.add(selMoneda, 0);

                        JPanel temp = new JPanel();
                        temp.setLayout(new FlowLayout(FlowLayout.CENTER));
                        temp.add(panelPreMoneda);
                        venMoneda.add(temp, 1);
                    }

                    venMoneda.repaint();
                    venMoneda.updateUI();
                }
            });
        }

    }
    class SeleccionMultiple extends JPanel {
        private JRadioButton[] buttons;
        private ButtonGroup buttonGroup;
        public SeleccionMultiple(String title, String[] options) {
            this(title, options, new GridLayout(1, options.length));
        }
        public SeleccionMultiple(String title, String[] options, LayoutManager layout) {
            super();
            buttons = new JRadioButton[options.length];
            buttonGroup = new ButtonGroup();

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(layout);

            for (int i = 0; i < options.length; i++) {
                buttons[i] = new JRadioButton(options[i]);
                buttonGroup.add(buttons[i]);
                buttonPanel.add(buttons[i]);
            }

            this.setLayout(new BorderLayout());
            this.add(new Label(title), BorderLayout.PAGE_START);
            this.add(buttonPanel, BorderLayout.CENTER);
        }
        public JRadioButton getSelected() {
            for (JRadioButton button : buttons) {
                if (button.isSelected()) {
                    return button;
                }
            }
            return null;
        }
        public JRadioButton[] getButtons() {
            return buttons;
        }
    }
}