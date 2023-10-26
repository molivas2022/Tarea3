package org.main.customexception;
import org.main.modelos.expendedor.Expendedor;

/**
 * Excepción que ocurre cuando se intenta retirar un objeto
 * de un contenedor vacio.
 * @see Expendedor
 * @author Askorin
 * @author molivas2022
 * @version 1.0.0 17-10-2023
 */
public class RetirarVacioException extends Exception {
    /**
     * Constructor único de la excepción
     * @param msg Se debe hacer ingreso de un mensaje descriptivo de la excepción
     */
    public RetirarVacioException(String msg) {
        super(msg);
    }
}
