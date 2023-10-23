package org.main.customexception;

import org.main.modelos.expendedor.Expendedor;

/**
 * Excepcion que ocurre cuando se intenta hacer una compra en expendedor
 * sin ingresar una moneda (<code>null</code>).
 * @see Expendedor
 * @author Askorin
 * @author molivas2022
 * @version 1.0.0 17-10-2023
 */
public class PagoIncorrectoException extends Exception {
    /**
     * Constructor unico de la excepcion
     * @param msg Se debe hacer ingreso de un mensaje descriptivo de la excepcion
     */
    public PagoIncorrectoException(String msg) {
        super(msg);
    }
}
