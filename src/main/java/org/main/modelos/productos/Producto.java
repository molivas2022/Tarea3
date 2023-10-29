package org.main.modelos.productos;

/**
 * Una clase abstracta que entrega las funcionalidades de un producto genérico..
 * @author Askorin
 * @author molivas2022
 * @version 1.0.0 17-10-2023
 * @see Bebida
 * @see Dulce
 */
public abstract class Producto {
    private String serie;

    /**
     * Método constructor único para un producto.
     * @param serie La serie que se desea para el producto.
     */
    public Producto(String serie) {
        this.serie = serie;
    }

    /**
     * Método abstracto que implementa el consumo del producto, a ser ocupado por un
     * <code>Comprador</code>.
     * @return El sabor del producto en formato <code>String</code>.
     */
    abstract public String consumir();

    /**
     * Permite acceder al campo de <code>Serie</code> del producto.
     * @return La serie del producto en formato <code>String</code>.
     */
    public String getSerie() {
        return serie;
    }

    /**
     * Devuelve la información identificatoria del producto.
     * @return La información del producto en formato <code>String</code>.
     */
    @Override
    public String toString() {
        return "Producto{" +
                "serie: '" + serie + '\'' +
                ", sabor: '" + this.consumir() + '\'' +
                '}';
    }
}
