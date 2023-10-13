package org.main.Moneda;

abstract public class Moneda implements Comparable {
    public String getSerie() {
        return super.toString();
    }
    abstract public int getValor();

    @Override
    public int compareTo(Object o) {
        if (o instanceof Moneda) {
            if (((Moneda)o).getValor() == this.getValor()) {
                return 1;
            }
        }
        return 0;
    }

    public String toString() {
        String str = String.format("Moneda de %d pesos. Código de serie: %s"
                , this.getValor(), this.getSerie());
        return str;
    }
}
