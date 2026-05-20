package PracticasDeUnidades.PracticoClase7;

public class Te extends Producto {
    //Atributos
    private int cantidadSaquitos;

    //Cosntructor
    public Te(int id, String nombre, int cantidad, Double precio, int cantidadSaquitos) {
        super(id, nombre, cantidad, precio);           //Llama al constructor de Producto
        this.cantidadSaquitos = cantidadSaquitos;
    }

    //Método
    @Override
    public void calcularPrecioFinal() {
        System.out.print(". Importe: $ "+cantidad*precio*0.8+ ", se aplicó 20% de descuento!!!!.");
    }

}