package org.main;
import org.main.Moneda.*;
import org.main.Producto.*;
import org.main.CustomException.*;

public class Expendedor {
    private Deposito<CocaCola> depCocaCola;
    private Deposito<Sprite> depSprite;
    private Deposito<Fanta> depFanta;
    private Deposito<Snickers> depSnickers;
    private Deposito<Super8> depSuper8;
    private Deposito<Moneda> depVuelto;

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

    public Producto comprarProducto(Moneda moneda, int id)
            throws  PagoInsuficienteException,
                    PagoIncorrectoException
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
            //Podriamos arrojar una excepción
            depVuelto.addObjeto(moneda);
            return null;
        }

        if (moneda.getValor() < precio) {
            depVuelto.addObjeto(moneda);
            throw new PagoInsuficienteException("El valor de la moneda es menor que del producto solicitado.");
        }

        Producto compra = (Producto)dep.getObjeto();
        if (compra == null) {
            // TODO: NoHayProductoException
            depVuelto.addObjeto(moneda);
            return null;
        }

        for (int i = 0; i < (moneda.getValor() - precio); i += 100) {
            depVuelto.addObjeto(new Moneda100());
        }
        return compra;
    }
    public Moneda getVuelto() {
        return depVuelto.getObjeto();
    }

}