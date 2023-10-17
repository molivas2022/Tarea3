package org.main;
import java.util.ArrayList;

public class Deposito<T> {
    final private ArrayList<T> objetos;

    public Deposito() {
        this.objetos = new ArrayList<>();
    }
    public void addObjeto(T obj) {
       objetos.add(obj);
    }
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
}
