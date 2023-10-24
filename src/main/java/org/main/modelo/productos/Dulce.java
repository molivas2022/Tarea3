package org.main.modelo.productos;

/**
 * Una clase abstracta que entrega las funcionalidades de un dulce.
 * @author Askorin
 * @author molivas2022
 * @version 1.0.0 17-10-2023
 * @see Snickers
 * @see Super8
 */
public abstract class Dulce extends Producto {
    /**
     * El método constructor de un dulce.
     * @param serie La serie que se desea para el dulce.
     */
    public Dulce(String serie) {
        super(serie);
    }
}
