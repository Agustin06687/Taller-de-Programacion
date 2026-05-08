package modelo;

import java.util.ArrayList;

public class Pedido {

    private Cliente cliente;
    private ArrayList<Producto> productos;
    private double total;
    private String estado;

    public Pedido(Cliente cliente, ArrayList<Producto> productos, double total, String estado) {
        this.cliente = cliente;
        this.productos = productos;
        this.total = total;
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public double getTotal() {
        return total;
    }

    public String getEstado() {
        return estado;
    }
}