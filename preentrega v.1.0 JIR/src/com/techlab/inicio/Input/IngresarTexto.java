package com.techlab.inicio.Input;
import java.util.Scanner;

public class IngresarTexto {
    public static String leerTextoNoVacio(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = scanner.nextLine();

            if (!texto.trim().isEmpty()) {
                return texto.trim();
            }

            System.out.println("Error: el texto no puede estar vacío.");
        }
    }

    public static Character leerConfirmacionNoVacia(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            Character confirma = scanner.next().charAt(0);

            if (!Character.isWhitespace(confirma)) {
                return confirma;
            }

            System.out.println("Error: la respuesta no puede ser vacía.");
        }
    }
}
