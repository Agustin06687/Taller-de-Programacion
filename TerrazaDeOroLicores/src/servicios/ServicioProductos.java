package servicios;

import java.util.ArrayList;
import modelo.Producto;

public class ServicioProductos {

    private ArrayList<Producto> productos;

    public ServicioProductos() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public ArrayList<Producto> listarProductos() {
        return productos;
    }

    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }
}
