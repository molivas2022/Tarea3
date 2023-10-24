package org.main.modelo.customexception;

import org.main.modelo.expendedor.Expendedor;

/**
 * Excepcion que ocurre cuando se intenta hacer una compra en expendedor
 * de un producto del cual ya no quedan unidades.
 * @see Expendedor
 * @author Askorin
 * @author molivas2022
 * @version 1.0.0 17-10-2023
 */
public class NoHayProductoException extends Exception {
    /**
     * Constructor unico de la excepcion
     * @param msg Se debe hacer ingreso de un mensaje descriptivo de la excepcion
     */
    public NoHayProductoException(String msg) {
        super(msg);
    }
}
