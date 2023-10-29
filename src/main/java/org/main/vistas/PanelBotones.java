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

/**
 * Contiene la vista y las llamadas al <code>Controlador</code> que permiten cambiar el modelo.
 * Modela la funcion que cumple un comprador.
 * @see Controlador
 * @see SeleccionMultiple
 * @author Askorin
 * @author molivas2022
 */
public class PanelBotones extends JPanel {
    /**
     * Constructor unico.
     */
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
        //TODO: Toda esta sección necesita refactor
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
     * Clase auxiliar que permite crear la vista y la logica para manipular una seleccion multiple.
     */
    public class SeleccionMultiple extends JPanel {
        /**
         * Conjunto de botones
         */
        private JRadioButton[] buttons;
        /**
         * Grupo que contiene el conjunto de botones.
         */
        private ButtonGroup buttonGroup;

        /**
         * Constructor de la seleccion multiple, cuya vista es por defecto de celdas.
         * @param title Texto que se desea imprmir como titulo de la seleccion multiple.
         * @param options Conjunto de textos de cada boton.
         */
        public SeleccionMultiple(String title, String[] options) {
            this(title, options, new GridLayout(1, options.length));
        }

        /**
         * Constructor de la seleccion multiple, especificando layout de la vista.
         * @param title Texto que se desea imprmir como titulo de la seleccion multiple.
         * @param options Conjunto de textos de cada boton.
         * @param layout Layout de la vista.
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
         * Devuelve el boton seleccionado.
         * @return El boton seleccionado, devuelve <code>null</code> si no se ha seleccionado ninguno.
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
         * Devuelve el conjunto de botones de la seleccion multiple.
         * @return Array de botones.
         */
        public JRadioButton[] getButtons() {
            return buttons;
        }
    }
}