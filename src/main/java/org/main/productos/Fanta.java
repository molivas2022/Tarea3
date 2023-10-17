package org.main.productos;

/**
 * Una clase que modela una bebida Fanta.
 * @author Askorin
 * @author molivas2022
 * @version 1.0.0 17-10-2023
 */
public class Fanta extends Bebida {

    /**
     * El método constructor para una Fanta.
     * @param serie La serie deseada para la Fanta.
     */
    public Fanta(String serie) {
        super(serie);
    }

    /**
     * Método que consume la Fanta, a ser utilizado por un <code>Comprador</code>.
     * @return El sabor de la Fanta en formato <code>String</code>.
     */
    @Override
    public String consumir() {
        return "Fanta";
    }
}
