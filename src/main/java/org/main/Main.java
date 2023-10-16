package org.main;
import org.main.CustomException.NoHayProductoException;
import org.main.CustomException.PagoIncorrectoException;
import org.main.CustomException.PagoInsuficienteException;
import org.main.Moneda.*;

public class Main {
    public static void main(String[] args) {

        // Creamos una máquina expendedora con  4 unidades de cada producto
        Expendedor exp = new Expendedor(0);

        // Creamos una moneda de 1000 pesos
        Moneda mon = new Moneda1000();
        System.out.println(mon); // Imprimimos la información de la moneda

        Comprador com;
        try {
            // Creamos un comprador, el cual va a intentar comprar un Snickers con la
            // moneda de 1000 pesos que le entregaremos
            com = new Comprador(mon, Catalogo.SNICKERS.getId(), exp);
            // Notemos que debería tener un vuelto de 200 pesos. Podemos consultarselo
            System.out.println( com.getVuelto() );
            // Podemos consultar tambien por el sabor del producto que compró
            System.out.println( com.queConsumiste() );
        } catch (PagoIncorrectoException pie) {
            System.err.println(pie.getMessage());
        } catch (PagoInsuficienteException pie) {
            System.err.println(pie.getMessage());
            // Si la moneda fuera insuficiente, la moneda sería devuelta por el expendedor como vuelto
            System.err.println( exp.getVuelto().toString() );
        } catch (NoHayProductoException e) {
            System.err.println(e.getMessage());
            System.out.println( exp.getVuelto().toString() );
        }

    }
}