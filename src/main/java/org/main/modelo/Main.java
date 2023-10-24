package org.main.modelo;
import org.main.modelo.comprador.Comprador;
import org.main.modelo.customexception.IdProductoNoExisteException;
import org.main.modelo.customexception.PagoIncorrectoException;
import org.main.modelo.expendedor.Expendedor;
import org.main.modelo.moneda.Moneda;
import org.main.modelo.moneda.Moneda1000;
// TODO: Actualizar UML con métodos nuevos, etc.

public class Main {
    public static void main(String[] args) {

        // Creamos una máquina expendedora con  4 unidades de cada producto
        Expendedor exp = new Expendedor(4);

        // Creamos una moneda de 1000 pesos.
        Moneda mon = new Moneda1000();
        System.out.println(mon); // Imprimimos la información de la moneda

        // Este será nuestro comprador.
        Comprador com;

        try {
            // Creamos un comprador, el cual va a intentar comprar un Snickers con la
            // moneda de 1000 pesos que le entregaremos
            com = new Comprador(mon, 1, exp);

            // Le consultamos el vuelto al comprador.
            System.out.println( com.getVuelto() );

            // Podemos consultar tambien por el sabor del producto que compró
            System.out.println( com.queConsumiste() );

        } catch (IdProductoNoExisteException | PagoIncorrectoException e) {
            System.err.println(e.getMessage());
        }
    }
}