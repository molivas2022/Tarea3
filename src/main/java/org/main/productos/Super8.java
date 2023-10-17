package org.main.productos;

/**
 * Una clase que modela un dulce Super8.
 * @author Askorin
 * @author molivas2022
 * @version 1.0.0 17-10-2023
 */
public class Super8 extends Dulce {

    /**
     * El método constructor para un Super8.
     * @param serie La serie deseada para el Super8.
     */
    public Super8(String serie) {
        super(serie);
    }

    /**
     * Método que consume el Super8, a ser utilizado por un <code>Comprador</code>.
     * @return El sabor del Super8 en formato <code>String</code>.
     */
    @Override
    public String consumir() {
        return "Super8";
    }
}
