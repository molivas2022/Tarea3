package org.main.vistas;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import org.main.modelos.moneda.*;

public class PanelMoneda extends JPanel {
    private Moneda moneda;
    private String truncatedSerie() {
        String serie = moneda.getSerie();
        String[] split = serie.split("@");
        return split[split.length - 1];
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
    class TextoSimple extends JLabel {
        public TextoSimple(String texto, int tamaño_font, int tamaño_label) {
            super(texto, JLabel.CENTER);
            setFont(new Font("Arial", Font.BOLD, tamaño_font));
            setPreferredSize(new Dimension(PanelMoneda.this.getWidth(), tamaño_label));
            setSize(PanelMoneda.this.getWidth(), tamaño_label);
        }
    }
}
