package org.main.modelos.expendedor;
import java.util.ArrayList;

/**
 * Clase cuya funcion es almacenar objetos de una clase generica <code>T</code>.
 * @see ArrayList
 * @param <T> Clase de los objetos que se van a almacenar
 * @author Askorin
 * @author molivas2022
 * @version 1.0.0 17-10-2023
 */
public class Deposito<T> {
    /**<code>ArrayList</code> usado para guardar los objetos que se ingresen*/
    final private ArrayList<T> objetos;

    public Deposito() {
        this.objetos = new ArrayList<>();
    }

    /**
     * Agrega un objeto a la coleccion.
     * @param obj Instancia de <code>T</code> que se va a agregar.
     */
    public void addObjeto(T obj) {
       objetos.add(obj);
    }

    /**
     * Retira el objeto mas antiguo que se ha agregado, quitandolo del deposito.
     * @return Instancia de <code>T</code> almacenada. Devuelve <code>null</code> si no hay objeto.
     */
    public T getObjeto() {
        if (objetos.isEmpty()) {
            return null;
        } else {
            /*
             * El depósito de una máquina expendedora debería ser FIFO, asi que removemos el objeto más vieja, la
             * del índice 0.
             */
            return objetos.remove(0);
        }
    }
<<<<<<< HEAD
    public int cuantosObjetos() {
        return objetos.size();
    }
    public T peekObjeto(int i) {
        return objetos.get(i);
=======
    public T peekObjeto(int i) {
        if (i >= objetos.size() || i < 0) {
            return null;
        } else {
            return objetos.get(i);
        }
>>>>>>> main
    }
}
