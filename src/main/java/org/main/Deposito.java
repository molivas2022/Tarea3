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
             * El depósito de una máquina expendedora debería ser LIFO, asi que removemos el objeto más vieja, la
             * del índice 0. Como se quiere que depósito sea lo más polimórfico posible, se podrían tener dos metodos,
             * uno LIFO y otro FIFO, que se usen dependiendo de la necesidad del caller.
             */
            return objetos.remove(0);
        }
    }
}
