package org.main.vistas;
import org.main.Controlador;
import org.main.modelos.productos.Catalogo;
import org.main.modelos.moneda.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PanelBotones extends JPanel {
    public PanelBotones() {
        super();

        setLayout(new GridLayout(4,1));
        setBackground(Color.white);

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
        venMoneda.setLayout(new BorderLayout());
        venMoneda.setPreferredSize(new Dimension(600, 100));
        venMoneda.add(selMoneda, BorderLayout.CENTER);

        add(venMoneda);

        //Boton Comprar
        JButton BotonCompra = new JButton("Comprar producto");
        add(BotonCompra);

        //Retirar Producto
        PanelRetiro pRet = new PanelRetiro();
        Controlador.setObservadorRetiro(pRet);
        add(pRet);

        BotonCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    if (selProducto.getSelected() == null) {
                        throw new Exception("Seleccione un producto.");
                    }

                    Catalogo producto = Catalogo.matchNombre(selProducto.getSelected().getText());

                    if (selMoneda.getSelected() == null) {
                        throw new Exception("Seleccione una moneda.");
                    }
                    Moneda monedaSeleccionada = EnumMoneda.matchNombre( selMoneda.getSelected().getText() ).newInstance();

                    Controlador.comprarProducto(monedaSeleccionada, producto);

                } catch (Exception e) {
                    PanelExcepcion.imprimir(e);
                }
            }
        });

        //Botones Seleccion Moneda
        for (JRadioButton b: selMoneda.getButtons()) {
            b.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    //Previsualización de selección de Moneda
                    if (selMoneda.getSelected() != null) {
                        Moneda preMoneda = EnumMoneda.matchNombre(selMoneda.getSelected().getText()).newInstance();
                        PanelMoneda panelPreMoneda = new PanelMoneda(preMoneda, 64, 64);

                        venMoneda.removeAll();
                        venMoneda.add(selMoneda, BorderLayout.CENTER);

                        JPanel panel = new JPanel(new GridBagLayout());
                        panel.add(panelPreMoneda, null);
                        panel.setPreferredSize(new Dimension(64 * 3, 64));
                        venMoneda.add(panel, BorderLayout.EAST);
                    }

                    venMoneda.updateUI(); //No entiendo que hace exactamente esta función
                }
            });
        }

    }

    /**
     * Clase de selección multiple para uso en <code>PanelBotones</code>.
     */
    class SeleccionMultiple extends JPanel {
        private JRadioButton[] buttons;
        private ButtonGroup buttonGroup;

        /**
         * Constructor para la clase.
         * @param title El título.
         * @param options Las opciones a usar.
         */
        public SeleccionMultiple(String title, String[] options) {
            this(title, options, new GridLayout(1, options.length));
        }

        /**
         * Constructor para la clase con uso de <code>LayoutManager</code>.
         * @param title El título.
         * @param options Las opciones a usar.
         * @param layout El <code>LayoutManager</code> a usar.
         */
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

        /**
         * Método que retorna el botón seleccionado de una <code>SeleccionMultiple</code>
         * @return JRadioButton el botón seleccionado, o <code>null</code>.
         */
        public JRadioButton getSelected() {
            for (JRadioButton button : buttons) {
                if (button.isSelected()) {
                    return button;
                }
            }
            return null;
        }

        /**
         * Método getter para los botones de una <code>SeleccionMultiple</code>
         * @return JRadioButton[] Los botones en un arreglo.
         */
        public JRadioButton[] getButtons() {
            return buttons;
        }
    }
}