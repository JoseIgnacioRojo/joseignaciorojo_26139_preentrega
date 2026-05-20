package PracticasDeUnidades.PracticoClase5;

public class Producto {
    String nombre;
    double precio;
    int cantidadEnStock;

    // Constructor con parámetros
    public Producto(String nombre, double precio, int cantidadEnStock) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadEnStock = cantidadEnStock;
    }
    //Método mostrarInformacion
    public void mostrarInformacion() {
        System.out.println("Nombre: "+this.nombre+", Precio: $"+this.precio+", Cantidad: "+this.cantidadEnStock);
    }
}
