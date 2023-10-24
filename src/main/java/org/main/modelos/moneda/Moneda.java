package org.main.modelos.moneda;

/**
 * Una clase abstracta que entrega las funcionalidades de una moneda.
 * @see Moneda100
 * @see Moneda500
 * @see Moneda1000
 * @see Moneda1500
 * @author Askorin
 * @author molivas2022
 * @version 1.0.0 17-10-2023
 */
abstract public class Moneda implements Comparable<Moneda> {
    /**
     * Permite acceder a la serie de la moneda, que corresponde a su direccion de memoria.
     * @return La serie de la moneda en formato <code>String</code>.
     */
    public String getSerie() {
        return super.toString();
    }

    /**
     * Permite acceder al valor monetario de la moneda.
     * @return El valor de la moneda como dato de tipo <code>int</code>.
     */
    abstract public int getValor();

    /**
     * Permite ordenar dos monedas, segun su valor.
     * @param m La moneda con cual se desea comparar.
     * @return Devuelve <code>1</code> si la moneda ingresada es de menor valor,
     * <code>0</code> si son del mismo valor, <code>-1</code> si es de mayor valor.
     */
    @Override
    public int compareTo(Moneda m) {
        if (m == null) {
            throw new NullPointerException("Se esta haciendo la comparación con una referencia nula.");
        }
        else if (this.getValor() > m.getValor()) {
            return 1;
        }
        else if (this.getValor() == m.getValor()) {
            return 0;
        }
        return -1;
    }

    /**
     * Devuelve la informacion identificatoria de moneda.
     * @return Devuelve <code>String</code> contieniendo la informacion de moneda.
     */
    public String toString() {
        String str = String.format("Moneda de %d pesos. Código de serie: %s"
                , this.getValor(), this.getSerie());
        return str;
    }
}
