package org.main;
import org.main.Moneda.*;
import org.main.Producto.*;

public class Main {
    public static void main(String[] args) {

        // Creamos una máquina expendedora con  4 unidades de cada producto
        Expendedor exp = new Expendedor(4);

        // Creamos una moneda de 1000 pesos
        Moneda mon = new Moneda1000();
        System.out.println( mon.toString() ); // Imprimimos la información de la moneda

        // Creamos un comprador, el cual va a intentar comprar un Snickers con la
        // moneda de 1000 pesos que le entregaremos
        Comprador com = new Comprador(mon, Catalogo.SNICKERS.getId(), exp);

        // Notemos que debería tener un vuelto de 200 pesos. Podemos consultarselo
        System.out.println( com.getVuelto() );

        // Podemos consultar tambien por el sabor del producto que compró
        System.out.println( com.queConsumiste() );
    }
}