package org.main.customexception;

import org.main.expendedor.Expendedor;

/**
 * Excepcion que ocurre cuando se intenta hacer una compra en expendedor
 * pero la moneda no satisface el valor del producto deseado.
 * @see Expendedor
 * @author Askorin
 * @author molivas2022
 * @version 1.0.0 17-10-2023
 */
public class PagoInsuficienteException extends Exception {
    /**
     * Constructor unico de la excepcion
     * @param msg Se debe hacer ingreso de un mensaje descriptivo de la excepcion
     */
    public PagoInsuficienteException(String msg) {
        super(msg);
    }
}
