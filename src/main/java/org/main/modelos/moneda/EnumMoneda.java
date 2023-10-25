package org.main.modelos.moneda;

import org.main.modelos.productos.Catalogo;

public enum EnumMoneda {
    MONEDA100(100, Moneda100.class , "Moneda de 100 pesos"),
    MONEDA500(500, Moneda500.class , "Moneda de 500 pesos"),
    MONEDA1000(1000, Moneda1000.class , "Moneda de 1000 pesos"),
    MONEDA1500(1500, Moneda1500.class , "Moneda de 1500 pesos");
    private int valor;
    private Class tipo;
    private String nombre;
    private EnumMoneda(int valor, Class tipo, String nombre) {
        this.valor = valor;
        this.tipo = tipo;
        this.nombre = nombre;
    }
    public int getValor() {
        return valor;
    }
    public String getNombre() {
        return nombre;
    }
    static public String[] getAllNombres() {
        String[] nombres = new String[EnumMoneda.values().length];
        for (int i = 0; i < EnumMoneda.values().length; i++) {
            nombres[i] = EnumMoneda.values()[i].getNombre();
        }
        return nombres;
    }
    static public EnumMoneda matchNombre(String nombre) {
        for (EnumMoneda m: EnumMoneda.values()) {
            if (m.getNombre() == nombre) {
                return m;
            }
        }
        return null;
    }
    public Moneda newInstance() {
        Moneda moneda = null;
        try {
            moneda = (Moneda)tipo.getDeclaredConstructor().newInstance();
        }
        catch (Exception e) {
            System.err.println(e);
        }
        return moneda;
    }
}
