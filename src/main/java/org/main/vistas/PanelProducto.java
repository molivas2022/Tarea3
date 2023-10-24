package org.main.vistas;
import org.main.modelos.productos.Producto;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PanelProducto extends JLabel {
    Producto producto;
    PanelProducto(Producto producto) {
        super();
        setPreferredSize(new Dimension(200, 200));
        this.producto = producto;
        BufferedImage imagen = null;
        try {
            if (producto.consumir() == "CocaCola") {
                imagen = ImageIO.read(getClass().getResource("/CocaCola.png"));
            } else if (producto.consumir() == "Sprite") {
                imagen = ImageIO.read(getClass().getResource("/Sprite.png"));
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        Image reImg = imagen.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        setIcon(new ImageIcon(reImg));
    }
}
