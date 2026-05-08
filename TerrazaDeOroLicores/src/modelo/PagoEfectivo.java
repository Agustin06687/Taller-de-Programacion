package modelo;

import javax.swing.JOptionPane;

public class PagoEfectivo implements Pago {

    @Override
    public void procesarPago(double total) {
        JOptionPane.showMessageDialog(null,
                "Pago en efectivo realizado. Total: $" + total);
    }
}
