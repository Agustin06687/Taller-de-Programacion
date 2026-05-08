package modelo;

public class Vino extends Producto {

    public Vino(String nombre, double precio, int stock) {
        super(nombre, precio, stock);
    }

    @Override
    public String mostrarTipo() {
        return "Vino";
    }
}
