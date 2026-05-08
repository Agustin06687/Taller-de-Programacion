package modelo;

public class Cerveza extends Producto {

    public Cerveza(String nombre, double precio, int stock) {
        super(nombre, precio, stock);
    }

    @Override
    public String mostrarTipo() {
        return "Cerveza";
    }
}
