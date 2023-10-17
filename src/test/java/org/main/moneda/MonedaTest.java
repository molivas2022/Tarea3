package org.main.moneda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonedaTest {
    @Test
    void  dosMonedasDe100SonIguales() {
        Moneda100 m1 = new Moneda100();
        Moneda100 m2 = new Moneda100();
        assertTrue( m1.compareTo(m2) == 1 );
    }
}