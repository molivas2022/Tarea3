package org.main.modelos.expendedor;
import org.main.customexception.*;
import org.main.modelos.moneda.Moneda;
import org.main.modelos.moneda.Moneda100;
import org.main.modelos.productos.*;

import java.util.ArrayList;

/**
 * Clase que modela una máquina expendedora.
 * Su funcion principal es modelar la compra de un producto deseado
 * a cambio de una moneda que cubra su valor.
 * @see Moneda
 * @see Deposito
 * @see Producto
 * @author Askorin
 * @author molivas2022
 * @version 1.0.0 17-10-2023
 */
public class Expendedor {

    /**Array donde se almacenan los depósitos de productos.**/
    private final ArrayList<Deposito<Producto>> depositosProducto;
    /**Deposito donde se almacena el vuelto en monedas de 100 pesos.*/
    final private Deposito<Moneda> depVuelto;
    /**Deposito donde se almacena el producto despues de una compra.**/
    private Producto compra;
    /**Capacidad de cantidad máxima de productos a almacenar.**/
    private final int CAPACIDAD = 6;
    private int primerNumSerie;

    /**
     *
     *  Constructor unico de Expendedor, recibe el numero de productos
     * con que debe rellenar sus depositos.
     */
    public Expendedor() {
        depositosProducto = new ArrayList<>();
        depVuelto = new Deposito<>();
        for (Catalogo c : Catalogo.values()) {
            depositosProducto.add(c.ordinal(), new Deposito<>());
        }


        /*
         * Llenamos los depósitos del expendedor con la cantidad especificada.
         * las ids de los productos serán numeros enteros sucesivos vueltos String.
         * Los números de serie partirán desde el 100.
         */

        primerNumSerie = 100;
        rellenar();

    }

    /**
     * Efectua la compra de un producto a cambio de una moneda.
     * @param moneda Moneda con cual se quiere comprar el producto.
     * @throws PagoInsuficienteException    En caso de que la moneda no cubra el valor del producto.
     * @throws PagoIncorrectoException      En caso de que la moneda ingresada sea invalida (<code>null</code>).
     * @throws NoHayProductoException       En caso de que no queden unidades del producto solicitado.
     * @throws IdProductoNoExisteException  En caso de que el identificador numerico sea invalido.
     */
    public void comprarProducto(Moneda moneda, Catalogo producto)
            throws PagoInsuficienteException,
            PagoIncorrectoException,
            NoHayProductoException,
            IdProductoNoExisteException,
            CompraNoRetiradaException
    {
        if (moneda == null) {
            throw new PagoIncorrectoException("No se ha hecho ingreso de una moneda.");
        }

        int precio = producto.getPrecio();
        Deposito<Producto> dep = depositosProducto.get(producto.ordinal());

        if (moneda.getValor() < precio) {
            depVuelto.addObjeto(moneda);
            throw new PagoInsuficienteException("El valor de la moneda es menor que del producto solicitado.");
        }

        if (compra != null) {
            depVuelto.addObjeto(moneda);
            throw new CompraNoRetiradaException("Existe un producto sin retirar en el depósito del expendedor.");
        }

        Producto compra = dep.getObjeto();
        if (compra == null) {
            depVuelto.addObjeto(moneda);
            throw new NoHayProductoException("No quedan productos del solicitado.");
        }

        for (int i = 0; i < (moneda.getValor() - precio); i += 100) {
            depVuelto.addObjeto(new Moneda100());
        }
        this.compra = compra;
    }

    public void rellenar() {
        int i = 0;
        for (Catalogo c : Catalogo.values()) {
            while (depositosProducto.get(c.ordinal()).cuantosObjetos() < CAPACIDAD) {
                Producto p = c.newInstance(Integer.toString(primerNumSerie + i));
                depositosProducto.get(c.ordinal()).addObjeto(p);
                ++i;
            }
        }
        // Esto es para llevar cuenta de dónde seguir los números de serie al rellenar.
        primerNumSerie = primerNumSerie + i;
    }

    /**
     * Permite extraer el vuelto de la compra moneda por moneda.
     * @return Devuelve una moneda de 100 pesos si falta por retirar vuelto, en caso contrario, devuelve <code>null</code>.
     */
    public Moneda getVuelto() throws RetirarVacioException {
        Moneda vuelto = depVuelto.getObjeto();
        if (vuelto == null) {
            throw new RetirarVacioException("No hay vuelto que retirar.");
        }


    public ArrayList<Deposito<Producto>> getDepositosProducto() {return depositosProducto;}
    public Deposito<Producto> getDepositoProducto(Catalogo producto) {
        return depositosProducto.get(producto.ordinal());
    }

    public Deposito<Moneda> getDepVuelto() {
        return depVuelto;
    }

    public Producto peekCompra() {
        return compra;
    }
    public Producto getCompra() throws RetirarVacioException {
        if (this.compra == null) {
            throw new RetirarVacioException("No hay producto que retirar.");
        }

        Producto compra = this.compra;
        this.compra = null;
        return compra;
    }
}
