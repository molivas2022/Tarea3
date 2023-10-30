package org.main.vistas;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import org.main.modelos.moneda.*;

/**
 * Vista de una <code>Moneda</code>.
 * @see Moneda
 * @author Askorin
 * @author molivas2022
 */
public class PanelMoneda extends JPanel {
    /**
     * <code>Moneda</code> que se quiere graficar.
     */
    private Moneda moneda;

    /**
     * Trunca la <code>serie</code>(Dirección de la referencia) de una <code>Moneda</code>
     * ignorando lo que esta a la izquierda del <code>@</code> (incluyendolo).
     * @return <code>Serie</code> truncada como <code>String</code>.
     */
    private String truncatedSerie() {
        String serie = moneda.getSerie();
        String[] split = serie.split("@");
        return split[split.length - 1];
    }

    /**
     * Deuelve el <code>valor</code> de la <code>Moneda</code> como un <code>String</code>.
     * @return <code>String</code> que contiene el valor de la <code>Moneda</code>.
     */
    private String valorAsString() {
        return Integer.toString(moneda.getValor());
    }

    /**
     * Constructor de la vista.
     * @param moneda <code>Moneda</code> que se quiere graficar.
     * @param width La anchura de la vista.
     * @param height La altura de la vista.
     */
    public PanelMoneda(Moneda moneda, int width, int height) {
        super();
        this.moneda = moneda;
        this.setSize(width, height);
        this.setPreferredSize(getSize());
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        //Información
        this.add(new TextoSimple("", 0,height/20));
        this.add(new TextoSimple( valorAsString(), (int)(height/2.5),height/2));
        this.add(new TextoSimple("Pesos", height/5,height/5));
        this.add(new TextoSimple( truncatedSerie(), height/8,height/4));

    }

    /**
     * Grafica la <code>Moneda</code>.
     * Especificamente: una imagen de una moneda, y por encima, el <code>valor</code> y la <code>serie</code>.
     * @param g  Contexto grafico en cual pintar.
     */
    public void paint(Graphics g) {
        //TODO: Añadir colores que representan valores
        super.paint(g);

        BufferedImage imagen = null;
        try {
            switch (moneda.getValor()) {
                case 100:
                    imagen = ImageIO.read(getClass().getResource("/Moneda100.png"));
                    break;
                case 500:
                    imagen = ImageIO.read(getClass().getResource("/Moneda500.png"));
                    break;
                case 1000:
                    imagen = ImageIO.read(getClass().getResource("/Moneda1000.png"));
                    break;
                case 1500:
                    imagen = ImageIO.read(getClass().getResource("/Moneda1500.png"));
                    break;
            }
        } catch (IOException e) {
            PanelExcepcion.imprimir(e);
        }
        Image reImg = imagen.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        g.drawImage(reImg, 0, 0, null);
        paintComponents(g);
    }

    /**
     * Clase auxiliar que facilita imprimir el texto de <code>PanelMoneda</code>.
     */
    private class TextoSimple extends JLabel {
        /**
         * Constructor del <code>JLabel</code> que contiene el texto.
         * @param texto Texto deseado.
         * @param size_font Longitud de la letra del texto.
         * @param size_label Longitud vertical del espacio que ocupa el <code>JLabel</code> de texto.
         */
        public TextoSimple(String texto, int size_font, int size_label) {
            super(texto, JLabel.CENTER);
            setFont(new Font("Arial", Font.BOLD, size_font));
            setPreferredSize(new Dimension(PanelMoneda.this.getWidth(), size_label));
            setSize(PanelMoneda.this.getWidth(), size_label);
        }
    }
}
