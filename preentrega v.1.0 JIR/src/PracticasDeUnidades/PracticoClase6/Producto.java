package PracticasDeUnidades.PracticoClase6;

import java.util.Scanner;

public class Producto {
    Scanner sc = new Scanner(System.in);

    //Atributos
    protected String nombre;
    protected double precio;
    protected int cantidadEnStock;
    protected int cantidadCreados;

    //Constructores
    // Constructor con parámetros
    public Producto(String nombre, double precio, int cantidadEnStock) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadEnStock = cantidadEnStock;
    }

    //Métodos
    public void setNombre(String nombre) {
        //Falta validar que el dato sea válido
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        //Falta validar que el dato sea número entero
        while (cantidad <= 0) {
            System.out.print("El stock tiene que ser mayor a cero. Por favor, ingresá cantidad de stock del producto: ");
            sc = new Scanner(System.in);
            cantidad = sc.nextInt();
        }
        this.cantidadEnStock = cantidad;
     }

    public int setCantCreados(Integer cantidad) {
        //Falta validar que el dato sea válido
        this.cantidadCreados = cantidad + 1;
        return cantidadCreados;
    }

    public double getPrecio() {
        return precio;
    }

    public double getCantidad() {
        return cantidadEnStock;
    }

    public int getCantCreados() {
        return cantidadCreados;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: "+this.nombre+", Precio: $"+this.precio+", Cantidad: "+this.cantidadEnStock);
    }

}
