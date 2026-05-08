package modelo;

public class Licor extends Producto {

    private double gradosAlcohol;

    public Licor(String nombre, double precio, int stock, double gradosAlcohol) {
        super(nombre, precio, stock);
        this.gradosAlcohol = gradosAlcohol;
    }

    public double getGradosAlcohol() {
        return gradosAlcohol;
    }

    public void setGradosAlcohol(double gradosAlcohol) {
        this.gradosAlcohol = gradosAlcohol;
    }

    @Override
    public String mostrarTipo() {
        return "Licor";
    }
}
