package org.main.vistas;
import javax.swing.JOptionPane;

public class PanelExcepcion {
    static public void imprimir(Exception e) {
        JOptionPane.showMessageDialog(null,
                e.getMessage(),
                truncateExceptionTitle(e),
                JOptionPane.ERROR_MESSAGE);
    }
    static private String truncateExceptionTitle(Exception e) {
        String[] var = ((e.getClass().toString()).split("\\."));
        String error_title = var[var.length - 1];
        return error_title;
    }
}
