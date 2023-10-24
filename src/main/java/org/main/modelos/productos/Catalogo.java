package org.main.modelos.productos;

import org.main.modelos.comprador.Comprador;
import org.main.modelos.expendedor.Expendedor;

/**
 * Enumeracion que describe la informacion relevante de los productos que maneja <code>Expendedor</code>.
 * @see Expendedor
 * @see Comprador
 * @author Askorin
 * @author molivas2022
 * @version 1.0.0 17-10-2023
 */
public enum Catalogo {
    /**Constante que describe el producto bebida CocaCola*/
    COCACOLA(1200, 1),
    /**Constante que describe el producto bebida Sprite*/
    SPRITE(1200, 2),
    /**Constante que describe el producto bebida Fanta*/
    FANTA(1200, 3),
    /**Constante que describe el producto dulce Snickers*/
    SNICKERS(800, 4),
    /**Constante que describe el producto dulce Super8*/
    SUPER8(800, 5);
    /**
     * Precio del producto.
     */
    private int precio;
    /**
     * Identificador numerico del producto que utiliza <code>Expendedor</code>.
     */
    private int id;

    /**
     * Constructor unico de los productos.
     * @param precio Precio del producto.
     * @param id Identificador del producto.
     */
    Catalogo (int precio, int id) {
        this.precio = precio;
        this.id = id;
    }

    /**
     * Permite acceder al precio de un producto.
     * @return Devuelve el precio del producto como dato de tipo <code>int</code>.
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Permite modificar el precio de un producto.
     * @param precio Nuevo precio que queremos que tome el producto.
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    /**
     * Permite acceder al identificador de un producto.
     * @return Devuelve el numero identificador del producto.
     */
    public int getId() {
        return id;
    }
    /**
     * Permite modificar el identificador de un producto.
     * @param id Nuevo identificador del producto.
     */
    public void setId(int id) {
        this.id = id;
    }

}
