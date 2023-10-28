package org.main.vistas;
import org.main.modelos.productos.Catalogo;
import org.main.modelos.productos.Producto;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

// TODO: Manejar casos null.
public class LabelProducto extends JLabel {
    private Producto producto;
    LabelProducto(Producto producto, int width, int height) {
        super();
        setSize(width, height);
        setPreferredSize(new Dimension(getWidth(), getHeight()));
        this.producto = producto;
        BufferedImage imagen = null;
            try {
                Catalogo aCargar = Catalogo.matchTipo(producto.getClass());
                String pathSprite = aCargar.getPathSprite();
                imagen = ImageIO.read(getClass().getResource(pathSprite));
            } catch (IOException e) {
                PanelExcepcion.imprimir(e);
            }
        Image reImg = imagen.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        setIcon(new ImageIcon(reImg));
    }

}
