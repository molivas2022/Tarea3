package org.main.vistas;
import org.main.modelos.productos.Producto;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

// TODO: Cambiarle el nombre, es un JLabel...
public class PanelProducto extends JLabel {
    Producto producto;
    PanelProducto(Producto producto, int width, int height) {
        super();
        setSize(width, height);
        setPreferredSize(new Dimension(getWidth(), getHeight()));
        this.producto = producto;
        BufferedImage imagen = null;
            try {
                switch (producto.consumir()) {
                    case "CocaCola":
                        imagen = ImageIO.read(getClass().getResource("/CocaCola.png"));
                        break;
                    case "Sprite":
                        imagen = ImageIO.read(getClass().getResource("/Sprite.png"));
                        break;
                    case "Fanta":
                        imagen = ImageIO.read(getClass().getResource("/Fanta.png"));
                        break;
                    case "Snickers":
                        imagen = ImageIO.read(getClass().getResource("/Snickers.png"));
                        break;
                    case "Super8":
                        imagen = ImageIO.read(getClass().getResource("/Super8.png"));
                        break;
                }
            } catch (IOException e) {
                PanelExcepcion.imprimir(e);
            }
        Image reImg = imagen.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        setIcon(new ImageIcon(reImg));
    }
}
