package org.main.modelos.productos;

/**
 * Enumeracion que describe la información relevante de los productos que maneja <code>Expendedor</code>.
 * @see Producto
 * @author Askorin
 * @author molivas2022
 * @version 1.0.0 17-10-2023
 */
public enum Catalogo {
    /**Constante que describe el producto bebida CocaCola*/
    COCACOLA(1000, CocaCola.class, "Coca Cola", "/CocaCola.png"),

    /**Constante que describe el producto bebida Sprite*/
    SPRITE(1000, Sprite.class, "Sprite", "/Sprite.png"),

    /**Constante que describe el producto bebida Fanta*/
    FANTA(1000, Fanta.class, "Fanta", "/Fanta.png"),

    /**Constante que describe el producto dulce Snickers*/
    SNICKERS(800, Snickers.class, "Snickers", "/Snickers.png"),

    /**Constante que describe el producto dulce Super8*/
    SUPER8(800, Super8.class, "Super 8", "/Super8.png");

    /**Precio del producto.*/
    private int precio;

    /**Identificador numérico del producto que utiliza <code>Expendedor</code>.*/
    private final Class<?> tipo;

    /**Precio del producto.*/
    private final String nombre;

    /**Path del sprite del producto en recursos.*/
    private final String pathSprite;

    /**
     * Constructor unico de los productos.
     * @param precio Precio del producto.
     */
    Catalogo (int precio, Class tipo, String nombre, String pathSprite) {
        this.precio = precio;
        this.tipo = tipo;
        this.nombre = nombre;
        this.pathSprite = pathSprite;
    }

    /**
     * Permite acceder al precio de un producto.
     * @return Devuelve el precio del producto como dato de tipo <code>int</code>.
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Permite acceder al precio de un producto en formato <code>String</code>:
     * @return Devuelve el precio del producto como dato de tipo <code>String</code>.
     */
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
     * Permite acceder al tipo de un producto.
     * @return Devuelve el tipo del producto en formato <code>Class</code>.
     */
    public Class getTipo() {
        return tipo;
    }

    /**
     * Permite acceder al nombre de un producto.
     * @return Devuelve el nombre del producto en formato <code>String</code>.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Permite acceder al path del sprite de un producto en los recursos.
     * @return Devuelve el path del sprite del producto en formato <code>String</code>.
     */
    public String getPathSprite() {
        return pathSprite;
    }

    /**
     * Permite acceder a los nombres de todos los productos enumerados.
     * @return Devuelve un <code>Array</code> de <code>String</code> correspondiente a todos los nombres.
     */
    static public String[] getAllNombres() {
        String[] nombres = new String[Catalogo.values().length];
        for (int i = 0; i < Catalogo.values().length; i++) {
            nombres[i] = Catalogo.values()[i].getNombre();
        }
        return nombres;
    }

    /**
     * Método para conseguir la enumeración correspondiente a un nombre específico de producto.
     * @param nombre El nombre sobre el que se desea hacer match.
     * @return la enumeración que corresponde al parámetro ingresado.
     */
    static public Catalogo matchNombre(String nombre) {
        for (Catalogo c: Catalogo.values()) {
            if (c.getNombre().equals(nombre)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Método para conseguir la enumeración correspondiente a un tipo específico de producto.
     * @param tipo El tipo sobre el que se desea hacer match.
     * @return la enumeración que corresponde al parámetro ingresado.
     */
    static public Catalogo matchTipo(Class tipo) {
        for (Catalogo c : Catalogo.values()) {
            if (c.getTipo().equals(tipo)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Método para instanciar un <code>Producto</code> con el número de serie correspndiente.
     * @param serie El número de serie del producto a instanciar en formato <code>String</code>.
     * @return un <code>Producto</code> del tipo correspondiente.
     */
    public Producto newInstance(String serie) {
        Producto producto = null;
        try {
            producto = (Producto) tipo.getDeclaredConstructor(String.class).newInstance(serie);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return producto;
    }
}
