package org.main.vistas;
import org.main.modelos.productos.Producto;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class PanelProducto extends JLabel {
    Producto producto;
    PanelProducto(Producto producto, int width, int height) {
        super();
        ArrayList<BufferedImage> spritesProductos = loadSprites();
        setSize(width, height);
        setPreferredSize(new Dimension(getWidth(), getHeight()));
        this.producto = producto;
        BufferedImage imagen = null;
        if (producto.consumir().equals("CocaCola")) {
            imagen = spritesProductos.get(0);
        } else if (producto.consumir().equals("Sprite")) {
            imagen = spritesProductos.get(1);
        }
        Image reImg = imagen.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        setIcon(new ImageIcon(reImg));
    }

    private ArrayList<BufferedImage> loadSprites() {
        System.out.println("Cargando imagenes");
        ArrayList<BufferedImage> spriteRet = new ArrayList<>();
        try {
            switch (producto.consumir()) {
                case "CocaCola":
                    imagen = ImageIO.read(getClass().getResource("/CocaCola.png")); break;
                case "Sprite":
                    imagen = ImageIO.read(getClass().getResource("/Sprite.png")); break;
                case "Fanta":
                    imagen = ImageIO.read(getClass().getResource("/Fanta.png")); break;
                case "Snickers":
                    imagen = ImageIO.read(getClass().getResource("/Snickers.png")); break;
                case "Super8":
                    imagen = ImageIO.read(getClass().getResource("/Super8.png")); break;
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        try {
            BufferedImage spriteSprite = ImageIO.read(getClass().getResource("/Sprite.png"));
            spriteRet.add(spriteSprite);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return spriteRet;
    }
}
