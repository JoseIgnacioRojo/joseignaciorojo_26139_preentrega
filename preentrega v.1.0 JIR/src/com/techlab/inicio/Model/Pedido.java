package com.techlab.inicio.Model;


import java.util.ArrayList;
import java.util.Scanner;
import com.techlab.inicio.Input.IngresarNro;
import com.techlab.inicio.Input.IngresarTexto;
import com.techlab.inicio.Model.Producto;
import com.techlab.inicio.Interfaces.Calculable;
import com.techlab.inicio.Model.ProductoElectronico;
import com.techlab.inicio.Model.ProductoAlimenticio;
import com.techlab.inicio.Excepciones.StockInsuficienteException;

public class Pedido {
    //Atributos
    private int codigo;
    private int nombre;
    private int cantidad;
    private double importeTotal;

    //Métodos
    public static ArrayList<Producto> ingresarPedido(
            Scanner scanner,
            ArrayList<Producto> productos,
            ArrayList<Categoria> categorias
    ) {
        System.out.println("\n--- INGRESAR PEDIDO ---");
        int codigoIngresado = IngresarNro.leerEntero(scanner, "Ingrese el código del producto a pedir. 0 para finalizar de cargar: ");
        int cantidadPedida;
        boolean cantidadSuficiente;
        String nombrePedido;
        Double precioDeLista;
        Categoria categoria;
        int codigoCategoria = 0;
        int garantiaMeses;
        int diasParaVencimiento;
        Pedido pedidos = new Pedido();
        ArrayList<Producto> pedido = new ArrayList<>();
        Double costoTotalPedido = 0.0;
        while (codigoIngresado != 0) {

            if (Producto.buscarProductoPorCodigo(productos, codigoIngresado) == null) {
                System.out.println("Error: el producto con ese código  no existe en el stock.");
                break;
            }

            cantidadPedida = IngresarNro.leerEntero(scanner, "Ingrese cantidad en stock del producto a pedir: ");

            cantidadSuficiente = descuentaStock(productos, codigoIngresado, cantidadPedida);
            if (cantidadSuficiente) {
                for (Producto producto : productos) {
                    if (producto.getCodigo() == codigoIngresado) {
                        nombrePedido = producto.getNombre();
                        precioDeLista = producto.getPrecio();
                        categoria = Categoria.buscarCategoriaPorCodigo(categorias, codigoIngresado);
                        codigoCategoria = categoria.getCodigo();
                        if (codigoCategoria == 1) {
                            garantiaMeses = IngresarNro.leerEnteroNoNegativo(scanner, "Ingrese la garantía en meses con la quiere el producto: ");
                            producto = new ProductoElectronico(codigoIngresado, nombrePedido, precioDeLista, cantidadPedida, categoria, garantiaMeses);
                        } else {
                            diasParaVencimiento = 30;
                            producto = new ProductoAlimenticio(codigoIngresado, nombrePedido, precioDeLista, cantidadPedida, categoria, diasParaVencimiento);
                        }

                        pedido.add(producto);

                        System.out.println("Producto ingresado correctamente.");
                        System.out.println("Resumen del producto agregado al pedido:");
                        System.out.println(producto);

                        costoTotalPedido += precioDeLista * cantidadPedida;
                    }
                }
            }

            codigoIngresado = IngresarNro.leerEntero(scanner, "Ingrese el código del producto a pedir. 0 para finalizar de cargar: ");
        } //del while (codgoIngresado != 0);
        System.out.println("Costo total del pedido= $"+ costoTotalPedido);
        //System.out.println("Precio final calculado: " + calcularPrecioFinal());

        return pedido;
    }

    public static boolean descuentaStock(
            ArrayList<Producto> productos,
            int codigoBuscado,
            int cantidadPedida
    ) {
        int stockActualizado;
        int CantidadEnStock;

        for (Producto producto : productos) {
            if (producto.getCodigo() == codigoBuscado) {
                CantidadEnStock = producto.getCantidad();
                //if (CantidadEnStock <= cantidadPedida) {
                //    System.out.println("Stock insuficiente para satisfacer el pedido. Stock actual: " + CantidadEnStock + ". ");
                if (StockInsuficienteException.main(CantidadEnStock, cantidadPedida)) {
                    return false;
                } else {
                    stockActualizado = CantidadEnStock - cantidadPedida;
                    producto.setCantidad(stockActualizado);
                    return true;
                }
            }
        }
        return false;
    }

    public static void listarPedidos(ArrayList<Producto> pedido) {
        System.out.println("\n--- LISTADO DEL PEDIDO ---");

        if (pedido.isEmpty()) {
            System.out.println("No hay un pedido cargado.");
            return;
        }
        double totalDelPedido = 0;
        for (Producto productoDelPedido : pedido) {
            System.out.println(productoDelPedido);

            //System.out.println("Total Pedido: " + pedido.importeTotal);
            totalDelPedido +=  productoDelPedido.getPrecio() * productoDelPedido.getCantidad();
            System.out.println("--------------------------------------------");
        }
        System.out.println("Total = $"+totalDelPedido);
    }

}