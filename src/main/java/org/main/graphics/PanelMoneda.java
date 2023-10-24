package org.main.graphics;

import javax.swing.*;
import java.awt.*;
import org.main.modelo.moneda.*;

public class PanelMoneda extends JPanel {
    private Moneda moneda;
    private String truncatedSerie() {
        String serie = moneda.getSerie();
        return serie.substring( serie.length() - 8 );
    }
    private String valorAsString() {
        return Integer.toString(moneda.getValor());
    }
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
    public void paint(Graphics g) {
        //TODO: Añadir colores que representan valores
        super.paint(g);
        g.setColor(Color.GRAY);
        g.fillOval(0, 0, getWidth(), getHeight());
        paintComponents(g);
    }
    class TextoSimple extends JLabel {
        public TextoSimple(String texto, int tamaño_font, int tamaño_label) {
            super(texto, JLabel.CENTER);
            setFont(new Font("Arial", Font.BOLD, tamaño_font));
            setPreferredSize(new Dimension(PanelMoneda.this.getWidth(), tamaño_label));
            setSize(PanelMoneda.this.getWidth(), tamaño_label);
        }
    }
}
