package org.main.modelo.productos;

/**
 * Una clase que modela un dulce Snickers.
 * @author Askorin
 * @author molivas2022
 * @version 1.0.0 17-10-2023
 */
public class Snickers extends Dulce {

    /**
     * El método constructor para un Snickers.
     * @param serie La serie deseada para el Snickers.
     */
    public Snickers(String serie) {
        super(serie);
    }

    /**
     * Método que consume el Snickers, a ser utilizado por un <code>Comprador</code>.
     * @return El sabor del Snickers en formato <code>String</code>.
     */
    @Override
    public String consumir() {
        return "Snickers";
    }
}
