package PracticasDeUnidades.PracticoClase6;

import java.util.ArrayList;

public class Carrito {
    //Atributos
    //private ArrayList<Producto> productosEnCarrito;
    private ArrayList<Producto> productosEnCarrito = new ArrayList<>();
    private int cantidad = 0;
    private double importe = 0;

    //Métodos
    public void setProductosEnCarrito(Producto producto) {
        this.productosEnCarrito.add(producto);
    }

    public void calculaImporte() {
        for (Producto producto : productosEnCarrito) {
            cantidad += producto.getCantidad();
            importe += (producto.getPrecio()*cantidad);
        }
        System.out.println("Cantidad de productos: "+cantidad+", importe total = "+importe);
    }
}