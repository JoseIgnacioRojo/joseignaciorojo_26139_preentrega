package PracticasDeUnidades.PracticoClase2;

import java.util.Scanner;

public class PracticoClase2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Por favor, ingresá tu nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Por favor, ingresá la cantidad de producto a comprar: ");
        int cantidad = sc.nextInt();

        double precio = 5000;
        double importe = cantidad * precio;

        if (cantidad > 100)
        {
            System.out.println("Por pedir más de 100 productos le haremos un 10% de descuento.");
            importe = importe * 0.9;
        }
        System.out.println("¡Hola " + nombre + "!, el monto total a pagar es de: $" + importe);


        System.out.print("Por favor, ingresá un número ");
        int numero = sc.nextInt();
        for (int i = 1; i <= numero; i++) {
            System.out.println(i);
        }

    }
}
