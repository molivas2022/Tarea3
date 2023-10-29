package org.main.modelos.moneda;

/**
 * Una enumeración que maneja información relevante de la clase <code>Moneda</code>.
 * @see Moneda
 * @author Askorin
 * @author molivas2022
 */
public enum EnumMoneda {
    /**Constante que describe una <code>Moneda</code> de 100 pesos.*/
    MONEDA100(100, Moneda100.class , "Moneda de 100 pesos"),
    /**Constante que describe una <code>Moneda</code> de 500 pesos.*/
    MONEDA500(500, Moneda500.class , "Moneda de 500 pesos"),
    /**Constante que describe una <code>Moneda</code> de 1000 pesos.*/
    MONEDA1000(1000, Moneda1000.class , "Moneda de 1000 pesos"),
    /**Constante que describe una <code>Moneda</code> de 1500 pesos.*/
    MONEDA1500(1500, Moneda1500.class , "Moneda de 1500 pesos");
    /**El valor de la moneda en cuestión.*/
    private final int valor;
    /**La clase de la moneda en cuestión.*/
    private final Class<?> tipo;
    /**El nombre de la moneda en cuestión.*/
    private final String nombre;
    EnumMoneda(int valor, Class<?> tipo, String nombre) {
        this.valor = valor;
        this.tipo = tipo;
        this.nombre = nombre;
    }

    /**
     * Método getter para el valor de un EnumMoneda.
     * @return Un entero, el valor correspondiente a la enumeración.
     */
    public int getValor() {
        return valor;
    }

    /**
     * Método getter para el nombre de un EnumMoneda.
     * @return Un <code>String</code>, el nombre correspondiente a la enumeración.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que retorna todos los nombres de todas las Enumeraciones de moneda.
     * @return Un <code>Array</code> de <code>String</code> que contiene todos los nombres en orden ordinal.
     */
    static public String[] getAllNombres() {
        String[] nombres = new String[EnumMoneda.values().length];
        for (int i = 0; i < EnumMoneda.values().length; i++) {
            nombres[i] = EnumMoneda.values()[i].getNombre();
        }
        return nombres;
    }

    /**
     * Método para conseguir la enumeración correspondiente a un nombre específico de moneda.
     * @param nombre El nombre sobre el que se desea hacer match.
     * @return el EnumMoneda que corresponde al parámetro ingresado.
     */
    static public EnumMoneda matchNombre(String nombre) {
        for (EnumMoneda m: EnumMoneda.values()) {
            if (m.getNombre().equals(nombre)) {
                return m;
            }
        }
        return null;
    }

    /**
     * Método para instanciar una <code>Moneda</code> del valor correspondiente a la enumeración.
     * @return una <code>Moneda</code> del tipo correspondiente.
     */
    public Moneda newInstance() {
        Moneda moneda = null;
        try {
            moneda = (Moneda)tipo.getDeclaredConstructor().newInstance();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return moneda;
    }
}
