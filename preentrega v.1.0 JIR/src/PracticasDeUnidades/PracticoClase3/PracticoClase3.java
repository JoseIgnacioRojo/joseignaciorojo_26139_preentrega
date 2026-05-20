package PracticasDeUnidades.PracticoClase3;

import java.util.ArrayList;

public class PracticoClase3 {

    public static void main(String[] args) {

        //Formatea completamente el string " té CHAi " : 1ra letra de cada palabra en mayúscula-Inicio
        String cadena = " té CHAi ";
        cadena = cadena.trim().toLowerCase();
        String[] palabras = cadena.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String palabra : palabras) {
            if (!palabra.isEmpty()) {
                sb.append(Character.toUpperCase(palabra.charAt(0))).append(palabra.substring(1)).append(" ");
            }
        }
        //Formatea completamente el string " té CHAi " : 1ra letra de cada palabra en mayúscula-Fin
        System.out.println(sb.toString().trim());

        System.out.println("Longitud: " + cadena.length() + ". Primera letra= " + cadena.charAt(0));
        int PosicionEnString = -1;
        PosicionEnString = cadena.indexOf("chai");

        if (PosicionEnString == -1) {
            System.out.println("La palabra chai no existe en el string.");
        }
        else {
            System.out.println("La palabra chai está en el string en la posición: " + PosicionEnString + " .");
        }

        //Array de 5 productos-Inicio
        String[] productos = new String[5];
        productos[0]="Queso crema 500 gr";
        productos[1]="Sachet de leche descremada Casanto 1 litro";
        productos[2]="Yogur La Serenísima sabor Vainilla entero 1 litro";
        productos[3]="Queso crema Ciudad del Lago 1 kg";
        productos[4]="Vitina 1000 gr.";

        for (String producto : productos) {
            System.out.println(producto);
        }
        //Array de 5 productos-Fin

        //ArrayList de 3 productos-Inicio
        ArrayList<String> listaProductos = new ArrayList<>();
        listaProductos.add("Sopa de cabellos de Ángel 500 gr.");
        listaProductos.add("Galletitas de coco y semillas de Chía.");
        listaProductos.add("Galletas marineras 500 gr.");
        listaProductos.remove("Sopa de cabellos de Ángel 500 gr.");
        for (String producto : listaProductos) {
            System.out.println(producto);
        }
        //Array de 3 productos-Fin

        //Invoca método que formatea texto en ArrayList
        FormateaTextoEnArrayList(listaProductos);


    }

    //Método que formatea texto en ArrayList-Inicio
    public static void FormateaTextoEnArrayList (ArrayList<String> listaString) {
        for (String producto : listaString) {
            producto = producto.trim().toLowerCase();
            String[] palabras = producto.split(" ");
            StringBuilder sb = new StringBuilder();
            for (String palabra : palabras) {
                if (!palabra.isEmpty()) {
                    sb.append(Character.toUpperCase(palabra.charAt(0))).append(palabra.substring(1)).append(" ");
                }
            }
            //Formatea completamente el string " té CHAi " : 1ra letra de cada palabra en mayúscula-Fin
            System.out.println(sb.toString().trim());
        }
    }
    //Método que formatea texto en ArrayList-Fin


}
