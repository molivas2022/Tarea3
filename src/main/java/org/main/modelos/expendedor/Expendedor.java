package org.main.modelos.expendedor;
import org.main.modelos.comprador.Comprador;
import org.main.modelos.customexception.IdProductoNoExisteException;
import org.main.modelos.customexception.NoHayProductoException;
import org.main.modelos.customexception.PagoIncorrectoException;
import org.main.modelos.customexception.PagoInsuficienteException;
import org.main.modelos.moneda.Moneda;
import org.main.modelos.moneda.Moneda100;
import org.main.modelos.productos.*;

/**
 * Clase que modela una maquina expendedora.
 * Su funcion principal es modelar la compra de un producto deseado
 * a cambio de una moneda que cubra su valor.
 * @see Comprador
 * @see Moneda
 * @see Deposito
 * @see Producto
 * @author Askorin
 * @author molivas2022
 * @version 1.0.0 17-10-2023
 */
public class Expendedor {
    /**Deposito donde se almacenan las unidades de la bebida CocaCola.*/
    private Deposito<CocaCola> depCocaCola;
    /**Deposito donde se almacenan las unidades de la bebida Sprite.*/
    private Deposito<Sprite> depSprite;
    /**Deposito donde se almacenan las unidades de la bebida Fanta.*/
    private Deposito<Fanta> depFanta;
    /**Deposito donde se almacenan las unidades del dulce Snickers.*/
    private Deposito<Snickers> depSnickers;
    /**Deposito donde se almacenan las unidades del dulce Super 8.*/
    private Deposito<Super8> depSuper8;
    /**Deposito donde se almacena el vuelto en monedas de 100 pesos.*/
    private Deposito<Moneda> depVuelto;

    /**
     * Constructor unico de Expendedor, recibe el numero de productos
     * con que debe rellenar sus depositos.
     * @param cantidadProductos Con cuantas unidades rellena cada deposito de los productos que maneja.
     */
    public Expendedor(int cantidadProductos) {
        depCocaCola = new Deposito<>();
        depSprite = new Deposito<>();
        depFanta = new Deposito<>();
        depSnickers = new Deposito<>();
        depSuper8 = new Deposito<>();
        depVuelto = new Deposito<>();
        /*
         * Llenamos los depósitos del expendedor con la cantidad especificada.
         * las ids de los productos serán numeros enteros sucesivos vueltos String.
         */
        for (int i = 0; i < cantidadProductos; ++i) {
            depCocaCola.addObjeto(new CocaCola(Integer.toString(100 + i)));
            depSprite.addObjeto(new Sprite(Integer.toString(100 + cantidadProductos + i)));
            depFanta.addObjeto(new Fanta(Integer.toString(100 + cantidadProductos * 2 + i)));
            depSnickers.addObjeto(new Snickers(Integer.toString(100 + cantidadProductos * 3 + i)));
            depSuper8.addObjeto(new Super8(Integer.toString(100 + cantidadProductos * 4 + i)));
        }
    }

    /**
     * Efectua la compra de un producto a cambio de una moneda.
     * @param moneda Moneda con cual se quiere comprar el producto.
     * @param id Identificador numerico del producto solicitado.
     * @return Devuelve una unidadd del producto deseado si la compra es exitosa.
     * @throws PagoInsuficienteException    En caso de que la moneda no cubra el valor del producto.
     * @throws PagoIncorrectoException      En caso de que la moneda ingresada sea invalida (<code>null</code>).
     * @throws NoHayProductoException       En caso de que no queden unidades del producto solicitado.
     * @throws IdProductoNoExisteException  En caso de que el identificador numerico sea invalido.
     */
    public Producto comprarProducto(Moneda moneda, int id)
            throws PagoInsuficienteException,
            PagoIncorrectoException,
            NoHayProductoException,
            IdProductoNoExisteException
    {
        if (moneda == null) {
            throw new PagoIncorrectoException("No se ha hecho ingreso de una moneda.");
        }

        int precio;
        Deposito<?> dep;

        if (id == Catalogo.COCACOLA.getId()) {
            precio = Catalogo.COCACOLA.getPrecio();
            dep = depCocaCola;
        } else if (id == Catalogo.SPRITE.getId()) {
            precio = Catalogo.SPRITE.getPrecio();
            dep = depSprite;
        } else if (id == Catalogo.FANTA.getId()) {
            precio = Catalogo.FANTA.getPrecio();
            dep = depFanta;
        } else if (id == Catalogo.SNICKERS.getId()) {
            precio = Catalogo.SNICKERS.getPrecio();
            dep = depSnickers;
        } else if (id == Catalogo.SUPER8.getId()) {
            precio = Catalogo.SUPER8.getPrecio();
            dep = depSuper8;
        } else {
            depVuelto.addObjeto(moneda);
            throw new IdProductoNoExisteException("No existe un producto con el ID ingresado.");
        }

        if (moneda.getValor() < precio) {
            depVuelto.addObjeto(moneda);
            throw new PagoInsuficienteException("El valor de la moneda es menor que del producto solicitado.");
        }

        Producto compra = (Producto) dep.getObjeto();
        if (compra == null) {
            depVuelto.addObjeto(moneda);
            throw new NoHayProductoException("No quedan productos del solicitado.");
        }

        for (int i = 0; i < (moneda.getValor() - precio); i += 100) {
            depVuelto.addObjeto(new Moneda100());
        }
        return compra;
    }

    /**
     * Permite extraer el vuelto de la compra moneda por moneda.
     * @return Devuelve una moneda de 100 pesos si falta por retirar vuelto, en caso contrario, devuelve <code>null</code>.
     */
    public Moneda getVuelto() {
        return depVuelto.getObjeto();
    }
}
