package PracticasDeUnidades;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        menuDeOpciones();
    }

        //Método MenuDeOpciones-Inicio
        public static void menuDeOpciones()
        {
            int opcionElegida = 1;
            do {
                System.out.println("------------------------------------------------------------------------------");
                System.out.println("Sistema de pedidos v.1.0");
                System.out.println(" ");
                System.out.println("1. Agregar productos.");
                System.out.println("0. Salir.");
                System.out.println("------------------------------------------------------------------------------");
                System.out.println(" ");

                System.out.print("Por favor, ingresá una opción de menú: ");
                Scanner sc = new Scanner(System.in);
                opcionElegida = sc.nextInt();

                if (opcionElegida == 1) {
                    agregarProductos();
                }
            } while (opcionElegida > 0);
        }
        //Método MenuDeOpciones-Fin

        //Método agregarProductos-Inicio
        public static void agregarProductos() {
            char continuarIngresandoProductos = 's';
            do {
                System.out.print("Por favor, ingresá nombre del producto: ");
                Scanner sc = new Scanner(System.in);
                String nombreProducto = sc.nextLine();
                System.out.print("Por favor, ingresá el precio del producto: ");
                sc = new Scanner(System.in);
                Double precioProducto = sc.nextDouble();
                System.out.print("Por favor, ingresá la cantidad del producto: ");
                sc = new Scanner(System.in);
                Integer cantidadEnStock = sc.nextInt();
                System.out.print("¿Desea seguir ingresando productos(s/n)?: ");
                sc = new Scanner(System.in);
                continuarIngresandoProductos = sc.next().charAt(0);
                while (continuarIngresandoProductos != 's' && continuarIngresandoProductos != 'n') {
                    System.out.print("Debe responder s o n. ¿Desea seguir ingresando productos(s/n)?.");
                    sc = new Scanner(System.in);
                    continuarIngresandoProductos = sc.next().charAt(0);;
                }
            } while (continuarIngresandoProductos == 's');
        }
        //Método agregarProductos-Fin
}