package org.main;
import org.main.customexception.NoHayProductoException;
import org.main.customexception.PagoIncorrectoException;
import org.main.customexception.PagoInsuficienteException;
import org.main.moneda.*;

public class Main {
    public static void main(String[] args) {

        // Creamos una máquina expendedora con  4 unidades de cada producto
        Expendedor exp = new Expendedor(0);

        // Creamos una moneda de 1000 pesos.
        Moneda mon = new Moneda1000();
        System.out.println(mon); // Imprimimos la información de la moneda

        // Este será nuestro comprador.
        Comprador com;

        try {
            // Creamos un comprador, el cual va a intentar comprar un Snickers con la
            // moneda de 1000 pesos que le entregaremos
            com = new Comprador(mon, Catalogo.SNICKERS.getId(), exp);

            // Le consultamos el vuelto al comprador.
            System.out.println( com.getVuelto() );

            // Podemos consultar tambien por el sabor del producto que compró
            System.out.println( com.queConsumiste() );

        } catch (PagoIncorrectoException e) {
            System.err.println(e.getMessage());
        }
    }
}