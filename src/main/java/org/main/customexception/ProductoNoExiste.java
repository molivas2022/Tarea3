package org.main.customexception;

import org.main.modelos.expendedor.Expendedor;

/**
 * Excepcion que ocurre cuando se intenta hacer una compra en expendedor
 * con un <code>Enum</code> de catálogo asociado a un <code>Producto</code> inválido.
 * @see Expendedor
 */
public class ProductoNoExiste extends Exception {
    /**
     * Constructor unico de la excepcion
     * @param msg Se debe hacer ingreso de un mensaje descriptivo de la excepcion
     */
    public ProductoNoExiste(String msg) {
        super(msg);
    }
}
