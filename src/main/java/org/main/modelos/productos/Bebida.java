package org.main.modelos.productos;

/**
 * Una clase abstracta que entrega las funcionalidades de una bebida.
 * @author Askorin
 * @author molivas2022
 * @version 1.0.0 17-10-2023
 * @see CocaCola
 * @see Fanta
 * @see Sprite
 */
public abstract class Bebida extends Producto {
    /**
     * El método constructor para una Bebida.
     * @param serie La serie que se desea para la bebida.
     */
    public Bebida(String serie) {
        super(serie);
    }
}
