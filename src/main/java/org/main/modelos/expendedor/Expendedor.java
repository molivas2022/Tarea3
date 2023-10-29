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
    /**Número serie que debe poseer el siguiente producto a rellenar. para uso del expendedor.**/
    private int primerNumSerie;

    /**
     * Constructor único de Expendedor.
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
         * estos partiran desde el 100.
         */

        primerNumSerie = 100;
        rellenar();

    }

    /**
     * Efectúa la compra de un <code>Producto</code> a cambio de una moneda y lo guarda en
     * su depósito de producto a ser retirado.
     * @param moneda <code>Moneda</code> con cual se quiere comprar el producto.
     * @param producto Enum correspondiente al <code>Producto</code> que se desea comprar.
     * @throws PagoInsuficienteException    En caso de que la <code>Moneda</code> no cubra el valor del producto.
     * @throws PagoIncorrectoException      En caso de que la <code>Moneda</code> ingresada sea inválida (<code>null</code>).
     * @throws NoHayProductoException       En caso de que no queden unidades del producto solicitado.
     * @throws IdProductoNoExisteException  En caso de que el producto no exista.
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

        if (producto == null) {
            throw new IdProductoNoExisteException("El producto no es valido.");
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

    /**
     * Rellena el <code>Expendedor</code> hasta su capacidad máxima.
     */
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
     * @return Devuelve una <code>Moneda</code>de 100 pesos si falta por retirar vuelto, en caso contrario, lanza excepción.
     * @throws RetirarVacioException en caso de que no quede una <code>Moneda</code> en el depósito de vuelto.
     */
    public Moneda getVuelto() throws RetirarVacioException {
        Moneda vuelto = depVuelto.getObjeto();
        if (vuelto == null) {
            throw new RetirarVacioException("No hay vuelto que retirar.");
        }
        return vuelto;
    }

    /**
     * Método getter para los depósitos de <code>Producto</code> de la instancia de <code>Expendedor</code>
     * @return Devuelve un <code>ArrayList</code> de <code>Deposito</code>.
     */
    public ArrayList<Deposito<Producto>> getDepositosProducto() {return depositosProducto;}

    /**
     * Método getter para un depósito de <code>Producto</code> de la instancia de <code>Expendedor</code> correspondiente al <code>Enum</code> del <code>Producto</code>
     * @return Devuelve un <code>Deposito</code> de <code>Producto</code>.
     */
    public Deposito<Producto> getDepositoProducto(Catalogo producto) {
        return depositosProducto.get(producto.ordinal());
    }

    /**
     * Método getter para el vuelto de una instancia de <code>Expendedor</code> en formato <code>Array</code>
     * @return Devuelve un <code>Array</code> de <code>Moneda</code>.
     */
    public Moneda[] peekVuelto() {
        Moneda[] vuelto = new Moneda[depVuelto.cuantosObjetos()];
        for (int i = 0; i < depVuelto.cuantosObjetos(); i++) {
            vuelto[i] = depVuelto.peekObjeto(i);
        }
        return vuelto;
    }

    /**
     * Método getter para el vuelto de una instancia de <code>Expendedor</code>.
     * @return Devuelve un <code>ArrayList</code> de <code>Moneda</code>.
     */
    public Deposito<Moneda> getDepVuelto() {
        return depVuelto;
    }

    /**
     * Método getter para la compra guardada en una instancia de <code>Expendedor</code> sin "retirarla".
     * @return Devuelve un <code>Producto</code>.
     */
    public Producto peekCompra() {
        return compra;
    }

    /**
     * Método para conseguir la compra guardada en una instancia de <code>Expendedor</code>, así retirándola."
     * @return Devuelve un <code>Producto</code>.
     * @throws RetirarVacioException en caso de no haber compra para retirar.
     */
    public Producto getCompra() throws RetirarVacioException {
        if (this.compra == null) {
            throw new RetirarVacioException("No hay producto que retirar.");
        }

        Producto compra = this.compra;
        this.compra = null;
        return compra;
    }
}
