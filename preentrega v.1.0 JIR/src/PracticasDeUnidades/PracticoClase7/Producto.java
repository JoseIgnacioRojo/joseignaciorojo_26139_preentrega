package PracticasDeUnidades.PracticoClase7;

import java.util.ArrayList;

public abstract class Producto {
    //Atributos
    protected int id;
    private String nombre;
    protected int cantidad;
    protected double precio;
    protected ArrayList<Producto> productos = new ArrayList<>();

    //Cosntructor
    public Producto(int id, String nombre, int cantidad, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    //Métodos
    public void calcularPrecioFinal(){
        System.out.print("Importe: $ "+cantidad*precio);
    }
    public void setProducto(Producto producto) {
        productos.add(producto);
    }
    public int getIdProducto() {return this.id;}
    public String getNombreProducto() {return this.nombre;}
}
