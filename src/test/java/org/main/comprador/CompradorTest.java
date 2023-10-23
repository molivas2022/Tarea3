package org.main.comprador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.main.modelos.comprador.Comprador;
import org.main.modelos.expendedor.Expendedor;
import org.main.customexception.IdProductoNoExisteException;
import org.main.customexception.NoHayProductoException;
import org.main.customexception.PagoIncorrectoException;
import org.main.customexception.PagoInsuficienteException;
import org.main.modelos.moneda.*;
import org.main.modelos.productos.Catalogo;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CompradorTest {

    private Moneda m100;
    private Moneda m500;
    private Moneda m1000;
    private Moneda m1500;
    private ArrayList<Moneda> monedas;
    private Expendedor exp;

    @BeforeEach
    void setUp() {
        /* Dejamos el catálogo en este estado. */
        Catalogo.COCACOLA.setPrecio(1500);
        Catalogo.COCACOLA.setId(1);

        Catalogo.FANTA.setPrecio(1500);
        Catalogo.FANTA.setId(2);

        Catalogo.SPRITE.setPrecio(1500);
        Catalogo.SPRITE.setId(3);

        Catalogo.SNICKERS.setPrecio(1500);
        Catalogo.SNICKERS.setId(4);

        Catalogo.SUPER8.setPrecio(1500);
        Catalogo.SUPER8.setId(5);

        /* Creamos monedas para usar en los test. */
        monedas = new ArrayList<>();
        m100 = new Moneda100();
        monedas.add(m100);
        m500 = new Moneda500();
        monedas.add(m500);
        m1000 = new Moneda1000();
        monedas.add(m1000);
        m1500 = new Moneda1500();
        monedas.add(m1500);

        /* Un expendedor para usar en algunos de los test. */
        exp = new Expendedor(100);
    }
    @Test
    void testPagoIncorrecto() {
        for (Catalogo producto : Catalogo.values()) {
            assertThrows(PagoIncorrectoException.class, () ->
                new Comprador(null, producto.getId(), exp)
            );
        }
    }
    @Test
    void testIdNoExiste() {
        for (Moneda m : monedas) {
            assertThrows(IdProductoNoExisteException.class, () ->
                new Comprador(m, 0, exp)
            );
            assertThrows(IdProductoNoExisteException.class, () ->
                new Comprador(m, 6, exp)
            );
        }
    }
    @Test
    void testPagoInsuficiente()
            throws PagoIncorrectoException,
            IdProductoNoExisteException

    {
        for (Moneda m : monedas) {
            for (Catalogo producto : Catalogo.values()) {
                /* Solo queremos testear casos en el que la moneda es de menor valor al precio. */
                if (m.getValor() >= producto.getPrecio()) continue;

                /* El consumidor no debería tener sabor al comprar con moneda de poco valor. */
                Comprador com = new Comprador(m, producto.getId(), exp);
                assertEquals(com.queConsumiste(), "nada");

                /* El vuelto del consumidor debe ser del mismo valor que su moneda. */
                assertEquals(com.getVuelto(), m.getValor());
            }
        }
    }
    @Test
    void testPagoPreciso()
            throws PagoIncorrectoException,
            IdProductoNoExisteException,
            NoHayProductoException,
            PagoInsuficienteException
    {
        for (Moneda m : monedas) {
            for (Catalogo producto : Catalogo.values()) {
                producto.setPrecio(m.getValor());

                /* El consumidor debería tener el sabor del producto que compró. */
                Comprador com = new Comprador(m, producto.getId(), exp);
                String saborEsperado = exp.comprarProducto(m, producto.getId()).consumir();
                assertEquals(com.queConsumiste(), saborEsperado);

                /* Su vuelto debería ser 0. */
                assertEquals(com.getVuelto(), 0);
            }
        }
    }
    @Test
    void testPagoIncorrectoEIdNoExiste() {
        /* Primero se lanza PagoIncorrecto, revisamos eso. */
        assertThrows(PagoIncorrectoException.class, () ->
            new Comprador(null, 0, exp)
        );
        assertThrows(PagoIncorrectoException.class, () ->
            new Comprador(null, 6, exp)
        );
    }
}
