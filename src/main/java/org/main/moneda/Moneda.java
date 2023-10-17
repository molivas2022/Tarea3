package org.main.moneda;

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
abstract public class Moneda implements Comparable {
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
     * Permite determinar si dos monedas son semejantes, compartiendo el mismo valor.
     * @param o El objeto que sea desea verificar semejanza.
     * @return Devuelve <code>1</code> en caso de ser una moneda del mismo valor.
     *         En caso contrario, devuelve <code>0</code>.
     */
    @Override
    public int compareTo(Object o) {
        if (o instanceof Moneda) {
            if (((Moneda)o).getValor() == this.getValor()) {
                return 1;
            }
        }
        return 0;
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
