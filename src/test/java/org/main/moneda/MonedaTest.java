package org.main.moneda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonedaTest {
    @Test
    void testMonedasDelMismoValor() {
        assertEquals(0, (new Moneda100()).compareTo(new Moneda100()));
        assertEquals(0, (new Moneda500()).compareTo(new Moneda500()));
        assertEquals(0, (new Moneda1000()).compareTo(new Moneda1000()));
        assertEquals(0, (new Moneda1500()).compareTo(new Moneda1500()));
    }
    @Test
    void testMonedasDeMenorValor() {
        assertTrue( (new Moneda1500()).compareTo(new Moneda1000()) > 0 );
        assertTrue( (new Moneda1000()).compareTo(new Moneda500()) > 0 );
        assertTrue( (new Moneda500()).compareTo(new Moneda100()) > 0 );
    }
    @Test
    void testMonedasDeMayorValor() {
        assertTrue( (new Moneda100()).compareTo(new Moneda500()) < 0 );
        assertTrue( (new Moneda500()).compareTo(new Moneda1000()) < 0 );
        assertTrue( (new Moneda1000()).compareTo(new Moneda1500()) < 0 );
    }
    @Test
    void testComparacionNull() {
        assertThrows(NullPointerException.class, () ->
        {   (new Moneda100()).compareTo(null);  });
        assertThrows(NullPointerException.class, () ->
        {   (new Moneda500()).compareTo(null);  });
        assertThrows(NullPointerException.class, () ->
        {   (new Moneda1000()).compareTo(null);  });
        assertThrows(NullPointerException.class, () ->
        {   (new Moneda1500()).compareTo(null);  });
    }
    @Test
    void testRecibirValorDeMoneda() {
        assertEquals(100, (new Moneda100()).getValor());
        assertEquals(500, (new Moneda500()).getValor());
        assertEquals(1000, (new Moneda1000()).getValor());
        assertEquals(1500, (new Moneda1500()).getValor());
    }
    @Test
    void testDosMonedasTienenDiferenteSerie() {
        // Mismo valor
        assertNotEquals((new Moneda100()).getSerie(), (new Moneda100()).getSerie());
        assertNotEquals((new Moneda500()).getSerie(), (new Moneda500()).getSerie());

        // Distinto valor
        assertNotEquals((new Moneda100()).getSerie(), (new Moneda500()).getSerie());
        assertNotEquals((new Moneda1000()).getSerie(), (new Moneda1500()).getSerie());
    }
}