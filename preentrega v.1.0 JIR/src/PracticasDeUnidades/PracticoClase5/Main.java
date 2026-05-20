package PracticasDeUnidades.PracticoClase5;

public class Main {
    public static void main(String[] args) {
        Cliente rojo = new Cliente("José Ignacio Rojo", "jirojo1976@yahoo.com.ar");

        Producto Cacao = new Producto("Cacao Nesquick 500 gr.",3500,24);
        Producto Leche = new Producto("Sachet de lecha La Serenísima",1400, 35);
        Cacao.mostrarInformacion();
        Leche.mostrarInformacion();
    }
}
