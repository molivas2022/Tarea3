package org.main;

/**
 * Lo implementan clases (Observadores) que dependen del estado de otras clases (Observados).
 * @author Askorin
 * @author molivas2022
 */
public interface Observador {
    /**
     * Cuando el estado de la clase observada cambia, se llama a este metodo.
     * Asi, la clase observador contiene el codigo necesario para reflejar esos cambios.
     */
    void cambioModelo();
}
