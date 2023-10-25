package org.main.modelos.expendedor;
import org.main.customexception.*;
import org.main.modelos.moneda.Moneda;
import org.main.modelos.moneda.Moneda100;
import org.main.modelos.productos.*;

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
    private Deposito[] depositosProducto;
    /**Deposito donde se almacenan las unidades de la bebida CocaCola.*/
    //TODO: Refactorizar para no usar MÁS muchos depositos de producto
    //TODO: Quitar uso de variables especificas por cada deposito de productos y usar depositosProducto
    final private Deposito<CocaCola> depCocaCola;
    /**Deposito donde se almacenan las unidades de la bebida Sprite.*/
    final private Deposito<Sprite> depSprite;
    /**Deposito donde se almacenan las unidades de la bebida Fanta.*/
    final private Deposito<Fanta> depFanta;
    /**Deposito donde se almacenan las unidades del dulce Snickers.*/
    final private Deposito<Snickers> depSnickers;
    /**Deposito donde se almacenan las unidades del dulce Super 8.*/
    final private Deposito<Super8> depSuper8;
    /**Deposito donde se almacena el vuelto en monedas de 100 pesos.*/
    final private Deposito<Moneda> depVuelto;
    /**Deposito donde se almacena el producto despues de una compra.**/
    private Producto compra;

    /**
     *
     *  Constructor unico de Expendedor, recibe el numero de productos
     * con que debe rellenar sus depositos.
     * @param cantidadProductos Con cuantas unidades rellena cada deposito de los productos que maneja.
     */
    public Expendedor(int cantidadProductos) {
        depCocaCola = new Deposito<> ();
        depSprite = new Deposito<>();
        depFanta = new Deposito<>();
        depSnickers = new Deposito<>();
        depSuper8 = new Deposito<>();

        depositosProducto = new Deposito[Catalogo.values().length];
        {   //TODO: no
            depositosProducto[Catalogo.COCACOLA.ordinal()] = depCocaCola;
            depositosProducto[Catalogo.SPRITE.ordinal()] = depSprite;
            depositosProducto[Catalogo.FANTA.ordinal()] = depFanta;
            depositosProducto[Catalogo.SNICKERS.ordinal()] = depSnickers;
            depositosProducto[Catalogo.SUPER8.ordinal()] = depSuper8;
        }

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
     * @throws PagoInsuficienteException    En caso de que la moneda no cubra el valor del producto.
     * @throws PagoIncorrectoException      En caso de que la moneda ingresada sea invalida (<code>null</code>).
     * @throws NoHayProductoException       En caso de que no queden unidades del producto solicitado.
     * @throws IdProductoNoExisteException  En caso de que el identificador numerico sea invalido.
     */
    public void comprarProducto(Moneda moneda, int id)
            throws PagoInsuficienteException,
            PagoIncorrectoException,
            NoHayProductoException,
            IdProductoNoExisteException,
            CompraNoRetiradaException
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

        if (compra != null) {
            depVuelto.addObjeto(moneda);
            throw new CompraNoRetiradaException("Existe un producto sin retirar en el depósito del expendedor.");
        }

        Producto compra = (Producto) dep.getObjeto();
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
     * Permite extraer el vuelto de la compra moneda por moneda.
     * @return Devuelve una moneda de 100 pesos si falta por retirar vuelto, en caso contrario, devuelve <code>null</code>.
     */
    public Moneda getVuelto() {
        return depVuelto.getObjeto();
    }

    public Deposito[] getDepositosProducto() {return depositosProducto;}
    public Deposito getDepositoProducto(Catalogo PRODUCTO) {
        return depositosProducto[PRODUCTO.ordinal()];
    }
    public Deposito<CocaCola> getDepCocaCola() {
        return depCocaCola;
    }

    public Deposito<Sprite> getDepSprite() {
        return depSprite;
    }

    public Deposito<Fanta> getDepFanta() {
        return depFanta;
    }

    public Deposito<Snickers> getDepSnickers() {
        return depSnickers;
    }

    public Deposito<Super8> getDepSuper8() {
        return depSuper8;
    }

    public Deposito<Moneda> getDepVuelto() {
        return depVuelto;
    }

    public Producto getCompra() {
        return compra;
    }
}
