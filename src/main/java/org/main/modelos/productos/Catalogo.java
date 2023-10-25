package org.main.modelos.productos;

import org.main.modelos.expendedor.Expendedor;

/**
 * Enumeracion que describe la informacion relevante de los productos que maneja <code>Expendedor</code>.
 * @see Expendedor
 * @author Askorin
 * @author molivas2022
 * @version 1.0.0 17-10-2023
 */
public enum Catalogo {
    /**Constante que describe el producto bebida CocaCola*/
    COCACOLA(1000, CocaCola.class, "Coca Cola", 0),
    /**Constante que describe el producto bebida Sprite*/
    SPRITE(1000, Sprite.class, "Sprite", 1),
    /**Constante que describe el producto bebida Fanta*/
    FANTA(1000, Fanta.class, "Fanta", 2),
    /**Constante que describe el producto dulce Snickers*/
    SNICKERS(800, Snickers.class, "Snickers", 3),
    /**Constante que describe el producto dulce Super8*/
    SUPER8(800, Super8.class, "Super 8", 4);
    /**
     * Precio del producto.
     */
    private int precio;
    /**
     * Identificador numerico del producto que utiliza <code>Expendedor</code>.
     */
    private Class tipo;
    private String nombre;
    private int id;
    /**
     * Constructor unico de los productos.
     * @param precio Precio del producto.
     * @param id Identificador del producto.
     */
    Catalogo (int precio, Class tipo, String nombre, int id) {
        this.precio = precio;
        this.tipo = tipo;
        this.nombre = nombre;
        this.id = id;
    }

    /**
     * Permite acceder al precio de un producto.
     * @return Devuelve el precio del producto como dato de tipo <code>int</code>.
     */
    public int getPrecio() {
        return precio;
    }
    public String precioAsString() {
        return Integer.toString(precio);
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
    public Class getTipo() {
        return tipo;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    static public String[] getAllNombres() {
        String[] nombres = new String[Catalogo.values().length];
        for (int i = 0; i < Catalogo.values().length; i++) {
            nombres[i] = Catalogo.values()[i].getNombre();
        }
        return nombres;
    }
    static public Catalogo matchNombre(String nombre) {
        for (Catalogo c: Catalogo.values()) {
            if (c.getNombre() == nombre) {
                return c;
            }
        }
        return null;
    }
}
