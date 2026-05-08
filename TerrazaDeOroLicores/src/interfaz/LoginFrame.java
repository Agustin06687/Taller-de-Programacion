package interfaz;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class LoginFrame extends JFrame {

    private final String ARCHIVO_USUARIOS = "usuarios.txt";

    public LoginFrame() {
        setTitle("Terraza de Oro Licores - Acceso");
        setSize(400, 300);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField correoField = new JTextField();
        JPasswordField contraseñaField = new JPasswordField();
        JButton loginButton = new JButton("Ingresar");
        JButton registerButton = new JButton("Registrar");

        loginButton.addActionListener(e -> {
            String correo = correoField.getText().trim();
            String password = new String(contraseñaField.getPassword()).trim();

            if (validarUsuario(correo, password)) {
                new ProductosFrame().setVisible(true);
                this.dispose(); 
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.");
            }
        });

        registerButton.addActionListener(e -> {
            String correo = correoField.getText().trim();
            String password = new String(contraseñaField.getPassword()).trim();

            if (correo.isEmpty() || password.length() < 4) {
                JOptionPane.showMessageDialog(this, "Clave mínima: 4 caracteres.");
            } else {
                guardarUsuario(correo, password);
                correoField.setText("");
                contraseñaField.setText("");
            }
        });

        panel.add(new JLabel("Usuario:"));
        panel.add(correoField);
        panel.add(new JLabel("Contraseña:"));
        panel.add(contraseñaField);
        panel.add(loginButton);
        panel.add(registerButton);
        add(panel);
    }

    private void guardarUsuario(String correo, String pass) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_USUARIOS, true))) {
            bw.write(correo + "," + pass);
            bw.newLine();
            JOptionPane.showMessageDialog(this, "Registrado.");
        } catch (IOException e) {}
    }

    private boolean validarUsuario(String correo, String pass) {
        File archivo = new File(ARCHIVO_USUARIOS);
        if (!archivo.exists()) return false;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] d = linea.split(",");
                if (d.length == 2 && d[0].equals(correo) && d[1].equals(pass)) return true;
            }
        } catch (IOException e) {}
        return false;
    }
}