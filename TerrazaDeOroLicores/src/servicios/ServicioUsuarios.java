package servicios;

import java.util.ArrayList;
import modelo.Usuario;

public class ServicioUsuarios {

    private ArrayList<Usuario> usuarios;

    public ServicioUsuarios() {
        usuarios = new ArrayList<>();
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}
