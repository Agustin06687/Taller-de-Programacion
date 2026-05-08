package modelo;

import javax.swing.JOptionPane;

public class PagoTarjeta implements Pago {

    @Override
    public void procesarPago(double total) {
        JOptionPane.showMessageDialog(null,
                "Pago con tarjeta realizado. Total: $" + total);
    }
}
