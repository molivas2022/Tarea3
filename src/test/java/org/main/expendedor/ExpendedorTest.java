package org.main.expendedor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.main.modelos.customexception.IdProductoNoExisteException;
import org.main.modelos.customexception.NoHayProductoException;
import org.main.modelos.customexception.PagoIncorrectoException;
import org.main.modelos.customexception.PagoInsuficienteException;
import org.main.modelos.expendedor.Expendedor;
import org.main.modelos.moneda.Moneda;
import org.main.modelos.moneda.Moneda100;
import org.main.modelos.moneda.Moneda1000;
import org.main.modelos.moneda.Moneda1500;
import org.main.modelos.productos.*;
import org.main.productos.*;
import org.main.customexception.*;
import org.opentest4j.AssertionFailedError;

import static org.junit.jupiter.api.Assertions.*;

class ExpendedorTest {
    private Expendedor e;
    @BeforeEach
    void testSetup() {
        e = new Expendedor(1);
        /* Dejamos el catálogo en este estado. */
        Catalogo.COCACOLA.setPrecio(1200);
        Catalogo.COCACOLA.setId(1);

        Catalogo.FANTA.setPrecio(1200);
        Catalogo.FANTA.setId(2);

        Catalogo.SPRITE.setPrecio(1200);
        Catalogo.SPRITE.setId(3);

        Catalogo.SNICKERS.setPrecio(800);
        Catalogo.SNICKERS.setId(4);

        Catalogo.SUPER8.setPrecio(800);
        Catalogo.SUPER8.setId(5);
    }
    @Test
    void testComprarBebidaExitosamente() {
        try {
            Moneda m = new Moneda1500();
            Producto p = e.comprarProducto(m, Catalogo.COCACOLA.getId());
            assertInstanceOf(CocaCola.class, p);
            assertInstanceOf(Bebida.class, p);

            int vuelto = 0;
            for (int i = 0; i < m.getValor() - Catalogo.COCACOLA.getPrecio(); i += 100) {
                Moneda temp = e.getVuelto();
                assertInstanceOf(Moneda100.class, temp);
                vuelto += temp.getValor();
            }
            assertNull(e.getVuelto());
            assertEquals(m.getValor() - Catalogo.COCACOLA.getPrecio(), vuelto);
        }
        catch (Exception e) {
            fail();
        }
    }
    @Test
    void testComprarDulceExitosamente() {
        try {
            Moneda m = new Moneda1000();
            Producto p = e.comprarProducto(m, Catalogo.SNICKERS.getId());
            assertInstanceOf(Snickers.class, p);
            assertInstanceOf(Dulce.class, p);

            int vuelto = 0;
            for (int i = 0; i < m.getValor() - Catalogo.SNICKERS.getPrecio(); i += 100) {
                Moneda temp = e.getVuelto();
                assertInstanceOf(Moneda100.class, temp);
                vuelto += temp.getValor();
            }
            assertNull(e.getVuelto());
            assertEquals(m.getValor() - Catalogo.SNICKERS.getPrecio(), vuelto);
        }
        catch (Exception e) {
            fail();
        }
    }
    @Test
    void testCompraFallidaPorMonedaNull() {
        assertThrows(PagoIncorrectoException.class, () -> {
            Producto p = e.comprarProducto(null, Catalogo.COCACOLA.getId());
        });
    }
    @Test
    void testCompraFallidaPorMonedaInsuficiente() {
        assertThrows(PagoInsuficienteException.class, () -> {
            Producto p = e.comprarProducto(new Moneda100(), Catalogo.COCACOLA.getId());
        });
    }
    @Test
    void testCompraFallidaPorFaltaDeProducto() {
        try {
            Producto p = e.comprarProducto(new Moneda1500(), Catalogo.COCACOLA.getId());
        }
        catch (Exception e) {}
        assertThrows(NoHayProductoException.class, () -> {
            Producto p = e.comprarProducto(new Moneda1500(), Catalogo.COCACOLA.getId());
        });
    }
    @Test
    void testCompraFallidaPorProductoInvalido() {
        assertThrows(IdProductoNoExisteException.class, () -> {
            Producto p = e.comprarProducto(new Moneda1500(), -1);
        });
    }
    @Test
    void testComprasReiteradas() {
        e = new Expendedor(3);
        testComprarBebidaExitosamente(); testComprarDulceExitosamente();
        testComprarBebidaExitosamente(); testComprarDulceExitosamente();
        testComprarBebidaExitosamente(); testComprarDulceExitosamente();
        assertThrows(AssertionFailedError.class, () -> {
            testComprarBebidaExitosamente();
        });
        assertThrows(AssertionFailedError.class, () -> {
            testComprarDulceExitosamente();
        });
    }
}