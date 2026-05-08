package interfaz;

import javax.swing.*;
import java.awt.*;

public class AdminFrame extends JFrame {

    public AdminFrame() {

        setTitle("Administrador");
        setSize(500, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JTextField nombreField = new JTextField();
        JTextField precioField = new JTextField();
        JTextField stockField = new JTextField();

        JButton agregarButton = new JButton("Agregar Producto");

        agregarButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,
                    "Producto agregado correctamente");
        });

        panel.add(new JLabel("Nombre"));
        panel.add(nombreField);

        panel.add(new JLabel("Precio"));
        panel.add(precioField);

        panel.add(new JLabel("Stock"));
        panel.add(stockField);

        panel.add(agregarButton);

        add(panel);
    }
}
