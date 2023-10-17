package org.main.productos;

/**
 * Una clase que modela una bebida Sprite.
 * @author Askorin
 * @author molivas2022
 * @version 1.0.0 17-10-2023
 */
public class Sprite extends Bebida {

    /**
     * El método constructor para una Sprite.
     * @param serie La serie deseada para la Sprite.
     */
    public Sprite(String serie) {
        super(serie);
    }

    /**
     * Método que consume la Sprite, a ser utilizado por un <code>Comprador</code>.
     * @return El sabor de la Sprite en formato <code>String</code>.
     */
    @Override
    public String consumir() {
        return "Sprite";
    }
}
