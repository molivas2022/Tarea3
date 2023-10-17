package org.main.customexception;

/**
 * Excepcion que ocurre cuando se intenta hacer una compra en expendedor
 * con la id invalida, no asociada a ningun producto.
 * @see org.main.Expendedor
 * @author Askorin
 * @author molivas2022
 * @version 1.0.0 17-10-2023
 */
public class IdProductoNoExisteException extends Exception {
    /**
     * Constructor unico de la excepcion
     * @param msg Se debe hacer ingreso de un mensaje descriptivo de la excepcion
     */
    public IdProductoNoExisteException(String msg) {
        super(msg);
    }
}
