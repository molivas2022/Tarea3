package org.main.customexception;
import org.main.modelos.expendedor.Expendedor;

/**
 * Excepción que ocurre cuando se intenta hacer una compra en expendedor
 * cuando no se ha retirado la compra anterior del depósito de compras.
 * @see Expendedor
 * @author Askorin
 * @author molivas2022
 * @version 1.0.0 17-10-2023
 */
public class CompraNoRetiradaException extends Exception {
    /**
     * Constructor único de la excepción
     * @param msg Se debe hacer ingreso de un mensaje descriptivo de la excepción
     */
    public CompraNoRetiradaException(String msg) {
        super(msg);
    }
}

