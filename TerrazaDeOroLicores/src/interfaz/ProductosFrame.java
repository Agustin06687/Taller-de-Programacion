package interfaz;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class ProductosFrame extends JFrame {

    
    private static ArrayList<String> historialVentas = new ArrayList<>();

    public ProductosFrame() {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setTitle("Terraza de Oro Licores - Gestión de Productos");
        setSize(900, 500);
        setLocationRelativeTo(null);

        
        String[] columnas = {"Producto", "Tipo", "Precio", "Stock"};
        Object[][] datos = {
            {"Aguardiente Antioqueño", "Licor", 45000.0, 30},
            {"Ron Viejo de Caldas", "Licor", 70000.0, 20},
            {"Club Colombia", "Cerveza", 10000.0, 100},
            {"Corona", "Cerveza", 10000.0, 100},
            {"Aguila Light", "Cerveza", 4000.0, 100},
            {"Aguila Original", "Cerveza", 4000.0, 100},
            {"Costeña Bacana", "Cerveza", 4500.0, 100},
            {"Costeñita", "Cerveza", 5000.0, 100},
            {"Old Parr", "Whisky", 180000.0, 15},
            {"Don Julio", "Tequila", 250000.0, 10}
        };

        
        DefaultTableModel modelo = new DefaultTableModel(datos, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };

        JTable tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);

        
        JPanel panelControl = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        JTextField txtCantidad = new JTextField(5);
            JButton btnComprar = new JButton("Comprar");
        JButton btnHistorial = new JButton("Ver Historial de Ventas");

        
        btnComprar.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            
            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione un producto de la tabla.");
                return;
            }

            try {
                int cantPedida = Integer.parseInt(txtCantidad.getText());
                int stockActual = (int) modelo.getValueAt(fila, 3);

                if (cantPedida > 0 && cantPedida <= stockActual) {
                    double precio = (double) modelo.getValueAt(fila, 2);
                    double total = precio * cantPedida;
                    String nombre = (String) modelo.getValueAt(fila, 0);

                 
                    int nuevoStock = stockActual - cantPedida;
                    modelo.setValueAt(nuevoStock, fila, 3);

                    
                    String registro = "Producto: " + nombre + "\n"+"Cantidad: " + cantPedida + "\n"+ "Precio Total: $" + total;
                    historialVentas.add(registro);

                    JOptionPane.showMessageDialog(this, "Compra procesada con éxito.\n" + registro);
                    txtCantidad.setText(""); 
                } else {
                    JOptionPane.showMessageDialog(this, "Stock insuficiente. Solo quedan: " + stockActual);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error: Ingrese un número entero en el campo de cantidad.");
            }
        });

        
        btnHistorial.addActionListener(e -> {
            if (historialVentas.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Aún no se han realizado ventas en esta sesión.");
            } else {
                StringBuilder reporte = new StringBuilder("=== REPORTE DE VENTAS ===\n\n");
                for (String venta : historialVentas) {
                    reporte.append(venta).append("\n------------------------------------------------\n");
                }

                JTextArea areaTexto = new JTextArea(reporte.toString());
                areaTexto.setEditable(false);
                areaTexto.setFont(new Font("Monospaced", Font.PLAIN, 12));
                
                JScrollPane scrollHistorial = new JScrollPane(areaTexto);
                scrollHistorial.setPreferredSize(new Dimension(500, 300));

                JOptionPane.showMessageDialog(this, scrollHistorial, "Historial Acumulado", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        
        panelControl.add(new JLabel("Cantidad:"));
        panelControl.add(txtCantidad);
        panelControl.add(btnComprar);
        panelControl.add(btnHistorial);

        setLayout(new BorderLayout());
        add(scroll, BorderLayout.CENTER);
        add(panelControl, BorderLayout.SOUTH);
    }
}