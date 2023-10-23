package org.main.deposito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.main.modelos.expendedor.Deposito;
import org.main.modelos.moneda.*;
import org.main.modelos.productos.CocaCola;
import org.main.modelos.productos.Producto;

import static org.junit.jupiter.api.Assertions.*;

class DepositoTest {
    private Deposito<Producto> depProducto;
    private Deposito<Moneda> depMoneda;

    @BeforeEach
    void setUp() {
        depProducto = new Deposito<>();
        depMoneda = new Deposito<>();

    }

    @Test
    void testDepositoProducto() {
        /* Intentamos remover objeto de deposito vacío. */
        assertDoesNotThrow(() ->
            depProducto.getObjeto()
        );

        /* Intentamos añadir y remover objetos de depósito. */
        assertDoesNotThrow(() -> {
            depProducto.addObjeto(new CocaCola("100"));
            depProducto.addObjeto(new CocaCola("100"));
            depProducto.addObjeto(new CocaCola("100"));
            depProducto.addObjeto(new CocaCola("100"));
            depProducto.getObjeto();
            depProducto.getObjeto();
            depProducto.getObjeto();
            depProducto.getObjeto();
            depProducto.getObjeto();
        });

        /* Nos aseguramos que la extracción funcione y sea FIFO */
        Producto testCoca1 = new CocaCola("200");
        Producto testCoca2 = new CocaCola("300");
        depProducto.addObjeto(testCoca1);
        depProducto.addObjeto(testCoca2);
        assertEquals(depProducto.getObjeto(), testCoca1);
        assertEquals(depProducto.getObjeto(), testCoca2);
    }
    @Test
    void testDepositoMoneda() {
        /* Intentamos remover objeto de deposito vacío. */
        assertDoesNotThrow(() ->
                depMoneda.getObjeto()
        );

        /* Intentamos añadir y remover objetos de depósito. */
        assertDoesNotThrow(() -> {
            depMoneda.addObjeto(new Moneda100());
            depMoneda.addObjeto(new Moneda500());
            depMoneda.addObjeto(new Moneda1000());
            depMoneda.addObjeto(new Moneda100());
            depMoneda.addObjeto(new Moneda1500());
            depMoneda.getObjeto();
            depMoneda.getObjeto();
            depMoneda.getObjeto();
            depMoneda.getObjeto();
            depMoneda.getObjeto();
        });

        /* Nos aseguramos que la extracción funcione y sea FIFO */
        Moneda testMon1 = new Moneda100();
        Moneda testMon2 = new Moneda500();
        depMoneda.addObjeto(testMon1);
        depMoneda.addObjeto(testMon2);
        assertEquals(depMoneda.getObjeto(), testMon1);
        assertEquals(depMoneda.getObjeto(), testMon2);

    }
}
