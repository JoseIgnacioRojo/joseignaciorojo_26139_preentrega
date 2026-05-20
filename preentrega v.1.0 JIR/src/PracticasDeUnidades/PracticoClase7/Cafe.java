package PracticasDeUnidades.PracticoClase7;

public class Cafe extends Producto   {
    //Atributos
    private int cantidadGramosPorCaja;

    //Cosntructor
    public Cafe(int id, String nombre, int cantidad, Double precio, int cantidadGramosPorCaja) {
        super(id, nombre, cantidad, precio);           //Llama al constructor de Producto
        this.cantidadGramosPorCaja = cantidadGramosPorCaja;
    }

    //Métodos
    @Override
    public void calcularPrecioFinal() {
        System.out.print(". Importe: $ "+cantidad*precio*0.9+", se aplicó 10% de descuento!!!.");
    }
}
