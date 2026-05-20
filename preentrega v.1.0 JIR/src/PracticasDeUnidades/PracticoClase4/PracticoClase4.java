package PracticasDeUnidades.PracticoClase4;

public class PracticoClase4 {
    public static void main(String[] args) {

    double calculo = 0;
    calculo = CalcularImpuesto(100.0,25.0);
    System.out.println("Cálculo de impuesto= " + calculo);
    calculo =CalcularImpuesto(1000.0, 20.0);
    System.out.println("Cálculo de impuesto= " + calculo);
    calculo =CalcularImpuesto(10000.0, 10.0);
    System.out.println("Cálculo de impuesto= " + calculo);

    calcularPrecioFinal(100.0, 10.0, 20);
    calcularPrecioFinal(1000.0, 5.0, 100);

    int[] stockProductos = new int[3];
    stockProductos[0] = 100;
    stockProductos[1] = 150;
    stockProductos[2] = 250;

    System.out.println("Stock antes de reposición= " + stockProductos[0] +", "+ stockProductos[1] +" y " + stockProductos[2]);
    reponerStock(stockProductos, 2);
    System.out.println("Stock después de reposición= " + stockProductos[0] +", "+ stockProductos[1] +" y " + stockProductos[2]);

    mostrarMensaje("José Ignacio Rojo");
        mostrarMensaje("José Ignacio Rojo",1);

    }
    //Método calcularImpuesto-Inicio
    public static double CalcularImpuesto(double precio, double porcentajeImpuesto) {
        return (precio + precio*(porcentajeImpuesto/100));
    }
    //Método calcularImpuesto-Fin

    //Método calcularPrecioFinal-Inicio
    public static void calcularPrecioFinal(double precio, double descuento, int cantidad) {
        if (cantidad > 50) {
            descuento += 5;
        }
        double precioSinDescuento;
        precioSinDescuento = precio * cantidad;
        double precioFinal;
        precioFinal = precioSinDescuento - precioSinDescuento * (descuento/100);
        System.out.println("Precio Final= " + precioFinal);
    }
    //Método calcularPrecioFinal-Fin

    //Método reponerStock-Inicio
    public static void reponerStock(int[] stockProductos , int posicion) {
        stockProductos[posicion] += 100;
    }
    //Método reponerStock-Fin


    //Ejemplo de sobrecarga de métodos
    //Métodos mostrarMensaje-Inicio
     public static void mostrarMensaje(String nombreCliente)
     {
         System.out.println("Bienvenido "+nombreCliente+" encantado de volver a verlo.");
     }

    public static void mostrarMensaje(String nombreCliente, int nuevoCliente)
    {
        System.out.println("Bienvenido al sistem de Stock "+nombreCliente+".");
    }
    //Métodos mostrarMensaje-Fin
}

