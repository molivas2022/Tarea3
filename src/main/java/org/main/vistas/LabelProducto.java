package org.main.vistas;
import org.main.modelos.productos.Catalogo;
import org.main.modelos.productos.Producto;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Clase para visualizar un <code>Producto</code> .
 */
public class LabelProducto extends JLabel {

    /** El <code>Producto</code> a visualizar. */
    private Producto producto;

    /**
     * Constructor único para la clase.
     * @param producto El <code>Producto</code> que se quiere mostrar.
     * @param width Su dimensión de ancho.
     * @param height Su dimnesión de alto.
     */
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
