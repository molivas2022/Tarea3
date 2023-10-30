package org.main.vistas;

import org.main.modelos.expendedor.Deposito;
import org.main.modelos.moneda.Moneda;
import org.main.modelos.productos.Producto;

import javax.swing.*;
import java.awt.*;

/**
 * Vista de un deposito del <code>Expendedor</code>.
 * @param <T> Clase de elementos que almacena el <code>Deposito</code>.
 * @see Deposito
 * @author Askorin
 * @author molivas2022
 */
public class PanelDeposito<T> extends JPanel {
    /**
     * Clase de elementos que almacena el <code>Deposito</code>.
     */
    private Class<T> type;
    /**
     * <code>Deposito</code> que se esta graficando.
     */
    private Deposito<T> deposito;
    /**
     * Ancho de la vista del <code>Deposito</code>.
     */
    public int width;
    /**
     * Altura de la vista del <code>Deposito</code>.
     */
    public int height;

    /**
     * Constructor de la vista.
     * @param type Clase de elementos que almacena el <code>Deposito</code>.
     * @param deposito <code>Deposito</code> que se esta graficando.
     * @param width Ancho de la vista del <code>Deposito</code>.
     * @param height Altura de la vista del <code>Deposito</code>.
     */
    public PanelDeposito(Class<T> type, Deposito<T> deposito, int width, int height) {
        super();
        this.type = type;
        this.deposito = deposito;
        this.width = width;
        this.height = height;
        setLayout(new FlowLayout(FlowLayout.LEFT));
        addComponents();

    }

    /**
     * Grafica un rectangulo que rodea al deposito.
     * @param g  Contexto grafico en cual pintar.
     */
    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(0,0,getWidth(),getHeight());
    }

    /**
     * Agrega las vistas de cada elemento del <code>Deposito</code>.
     */
    private void addComponents() {
        for (int i = 0; i < deposito.cuantosObjetos(); i++) {
            JPanel panel = null;
            if (type == Moneda.class) {
                panel = new PanelMoneda((Moneda) deposito.peekObjeto(i), width, height);
                add(panel);
            } else if (Producto.class.isAssignableFrom(type)) {
                JLabel label = new LabelProducto((Producto) deposito.peekObjeto(i), width, height);
                add(label);
            }
        }
    }
}
