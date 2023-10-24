package org.main.modelo.productos;

/**
 * Una clase que modela una bebida CocaCola.
 * @author Askorin
 * @author molivas2022
 * @version 1.0.0 17-10-2023
 */
public class CocaCola extends Bebida {

    /**
     * El método constructor para una CocaCola.
     * @param serie La serie deseada para la CocaCola.
     */
    public CocaCola(String serie) {
        super(serie);
    }

    /**
     * Método que consume la CocaCola, a ser utilizado por un <code>Comprador</code>.
     * @return El sabor de la CocaCola en formato <code>String</code>.
     */
    @Override
    public String consumir() {
        return "CocaCola";
    }
}
