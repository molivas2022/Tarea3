package org.main.moneda;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonedaTest {
    private Moneda m100_1, m100_2, m500_1;
    @BeforeEach
    void testSetup() {
        m100_1 = new Moneda100();
        m100_2 = new Moneda100();
        m500_1 = new Moneda500();
    }
    @Test
    void testMonedasDelMismoValor() {
        assertEquals(1, m100_1.compareTo(m100_2));
    }
    @Test
    void testMonedasDeDistintoValor() {
        assertNotEquals(1, m100_1.compareTo(m500_1));
    }
    @Test
    void testRecibirValorDeMonedaDe500() {
        assertEquals(500, m500_1.getValor());
    }
    @Test
    void testDosMonedasDe100TienenDistintaSerie() {
        assertNotEquals(m100_1.getSerie(), m100_2.getSerie());
    }
}