package org.main;
import org.main.Moneda.*;
import org.main.Producto.*;

public class Expendedor {
    private int precioBebidas;
    private int precioDulces;
    private Deposito<CocaCola> depCocaCola;
    private Deposito<Sprite> depSprite;
    private Deposito<Fanta> depFanta;
    private Deposito<Snickers> depSnickers;
    private Deposito<Super8> depSuper8;
    private Deposito<Moneda> depVuelto;
    public Producto comprarProducto(Moneda moneda, int id) {
        if (moneda == null) {
            // TODO: PagoIncorrectoException
            return null;
        }

        int precio;
        Deposito dep;

        // Podriamos buscar una solución más optima a buscar el deposito y precio
        if (id == Catalogo.COCACOLA.getId()) {
            precio = precioBebidas;
            dep = depCocaCola;
        } else if (id == Catalogo.SPRITE.getId()) {
            precio = precioBebidas;
            dep = depSprite;
        } else if (id == Catalogo.FANTA.getId()) {
            precio = precioBebidas;
            dep = depFanta;
        } else if (id == Catalogo.SNICKERS.getId()) {
            precio = precioDulces;
            dep = depSnickers;
        } else if (id == Catalogo.SUPER8.getId()) {
            precio = precioDulces;
            dep = depSuper8;
        } else {
            //Podriamos arrojar una excepción
            depVuelto.addObjeto(moneda);
            return null;
        }

        if (moneda.getValor() < precio) {
            // TODO: PagoInsuficienteException
            depVuelto.addObjeto(moneda);
            return null;
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
        return null;
    }

}
