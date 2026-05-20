package com.techlab.inicio.Menu;

import java.util.Scanner;
import java.util.ArrayList;
import com.techlab.inicio.Model.Producto;
import com.techlab.inicio.Model.Categoria;
import com.techlab.inicio.Input.IngresarTexto;
import com.techlab.inicio.Input.IngresarNro;
import com.techlab.inicio.Model.Pedido;

public class MenuPral {
    public static void main() {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Producto> productos = new ArrayList<>();
        ArrayList<Categoria> categorias = new ArrayList<>();
        ArrayList<Producto> pedido = new ArrayList<>();

        Categoria.precargarCategorias(categorias);

        int opcionElegida;

        do {
            System.out.println("\n======================================================");
            System.out.println(" Sistema de lógistica v.1.0");
            System.out.println("======================================================");
            System.out.println("1 - Ingresar stock.");
            System.out.println("2 - Listar productos en stock.");
            System.out.println("3 - Consultar un producto en stock.");
            System.out.println("4 - Modificar un producto en stock.");
            System.out.println("5 - Eliminar un producto en stock.");
            System.out.println("6 - Listar categorías.");
            System.out.println("7 - Crear pedido.");
            System.out.println("8 - Listar pedidos.");
            System.out.println("0 - Salir.");
            System.out.println("======================================================");

            opcionElegida = IngresarNro.leerEntero(scanner, "Ingrese una opción: ");

            switch (opcionElegida) {
                case 1:
                    Producto.ingresarProducto(scanner, productos, categorias);
                    break;
                case 2:
                    Producto.listarProductos(productos);
                    break;
                case 3:
                    Producto.consultarProducto(scanner, productos);
                    break;
                case 4:
                    Producto.modificarProducto(scanner, productos, categorias);
                    break;
                case 5:
                    Producto.eliminarProducto(scanner, productos);
                    break;
                case 6:
                    Categoria.listarCategorias(categorias);
                    break;
                case 7:
                    pedido = Pedido.ingresarPedido(scanner, productos, categorias);
                    break;
                case 8:
                    Pedido.listarPedidos(pedido);
                    break;
                case 0:
                    System.out.println("\nSaliendo del sistema. Gracias por usar el sistema de logística ¡Hasta la próxima!.");
                    break;
                default:
                    System.out.println("\nError: la opción ingresada no es válida.");
            }

        } while (opcionElegida != 0);

        scanner.close();


    }


}
