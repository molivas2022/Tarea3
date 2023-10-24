package org.main.producto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.main.modelo.productos.*;
import org.main.productos.*;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ProductoTest {

    private ArrayList<Bebida> bebidas;
    private ArrayList<Dulce> dulces;
    private String serieBebida;
    private String serieDulce;

    @BeforeEach
    void setUp() {
        bebidas = new ArrayList<>();
        dulces = new ArrayList<>();

        bebidas.add(new CocaCola("100"));
        bebidas.add(new Fanta("100"));
        bebidas.add(new Sprite("100"));

        dulces.add(new Snickers("200"));
        dulces.add(new Super8("200"));
    }

    @Test
    void testBebidas() {
        for (Bebida b : bebidas) {
            boolean condCoca = b instanceof CocaCola && "CocaCola".equals(b.consumir());
            boolean condFanta = b instanceof Fanta && "Fanta".equals(b.consumir());
            boolean condSprite = b instanceof Sprite && "Sprite".equals(b.consumir());
            assertTrue(condCoca ^ condFanta ^ condSprite);
        }
    }
    @Test
    void testDulces() {
        for (Dulce d : dulces) {
            boolean condSnickers = d instanceof Snickers && "Snickers".equals(d.consumir());
            boolean condSuper8 = d instanceof Super8 && "Super8" .equals(d.consumir());
            assertTrue(condSnickers ^ condSuper8);
        }
    }
    @Test
    void testSeries() {
        ArrayList<String> series = new ArrayList<>();
        /* Casos borde */
        series.add("");
        series.add("0");
        series.add("---%1--.");

        /* Casos random */
        for (int i = 0; i < 50; ++i) {
            Random rand = new Random();
            int int_random = rand.nextInt(10000);
            series.add(Integer.toString(int_random));
        }
        for (String s : series) {
            CocaCola coca = new CocaCola(s);
            Fanta fanta = new Fanta(s);
            Sprite sprite = new Sprite(s);
            Snickers snickers = new Snickers(s);
            Super8 super8 = new Super8(s);
            assertAll(
                    () -> assertEquals(s, coca.getSerie()),
                    () -> assertEquals(s, fanta.getSerie()),
                    () -> assertEquals(s, sprite.getSerie()),
                    () -> assertEquals(s, snickers.getSerie()),
                    () -> assertEquals(s, super8.getSerie())
            );

        }
    }
}
