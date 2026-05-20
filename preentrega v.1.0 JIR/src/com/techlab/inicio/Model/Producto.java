package com.techlab.inicio.Model;

import java.util.Scanner;
import java.util.ArrayList;
import com.techlab.inicio.Input.IngresarNro;
import com.techlab.inicio.Input.IngresarTexto;
import com.techlab.inicio.Interfaces.Calculable;

public abstract class Producto {

    //Atributos
    private  int codigo;
    private String nombre;
    private Double precio;
    private int cantidad;
    private Categoria categoria;


    public Producto(int codigo, String nombre, double precio, int cantidad, Categoria categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }


    //Métodos
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public abstract String getTipoProducto();

    public abstract String getDetalleEspecifico();

    @Override
    public String toString() {
        return "Producto {" +
                "código=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", precio base=" + precio +
                ", stock=" + cantidad +
                ", categoría='" + categoria.getNombre() + '\'' +
                ", tipo='" + getTipoProducto() + '\'' +
                ", detalle='" + getDetalleEspecifico() + '\'' +
                //", precio final=" + calcularPrecioFinal() +
                '}';
    }



    public static void ingresarProducto(
            Scanner scanner,
            ArrayList<Producto> productos,
            ArrayList<Categoria> categorias
    ) {
        System.out.println("\n--- INGRESAR PRODUCT ---");
        System.out.println("1 - Producto electrónico");
        System.out.println("2 - Producto alimenticio");

        int tipo;
        do {
            tipo = IngresarNro.leerEntero(scanner, "Seleccione el tipo de producto: ");
            if (tipo != 1 && tipo != 2) {
                System.out.println("Error: debe elegir 1 o 2.");
            }
        } while (tipo != 1 && tipo != 2);

        int codigo = IngresarNro.leerEntero(scanner, "Ingrese el código del producto: ");

        if (buscarProductoPorCodigo(productos, codigo) != null) {
            System.out.println("Error: ya existe un producto con ese código.");
            return;
        }

        String nombre = IngresarTexto.leerTextoNoVacio(scanner, "Ingrese el nombre del producto: ");
        double precio = IngresarNro.leerDoubleNoNegativo(scanner, "Ingrese el precio del producto: ");
        int cantidad = IngresarNro.leerEntero(scanner, "Ingrese cantidad en stock del producto: ");

        Categoria.listarCategorias(categorias);
        Categoria categoria = Categoria.pedirCategoriaExistente(scanner, categorias);

        Producto producto;

        if (tipo == 1) {
            int garantiaMeses = IngresarNro.leerEnteroNoNegativo(scanner, "Ingrese la garantía en meses: ");
            producto = new ProductoElectronico(codigo, nombre, precio, cantidad, categoria, garantiaMeses);
        } else {
            int diasParaVencimiento = IngresarNro.leerEnteroNoNegativo(scanner, "Ingrese los días para vencimiento: ");
            producto = new ProductoAlimenticio(codigo, nombre, precio, cantidad, categoria, diasParaVencimiento);
        }

        productos.add(producto);

        System.out.println("Producto ingresado correctamente.");
        System.out.println("Resumen del objeto creado:");
        System.out.println(producto);
        //System.out.println("Precio final calculado: " + calcularPrecioFinal());
    }

    public static void listarProductos(ArrayList<Producto> productos) {
        System.out.println("\n--- LISTADO DE PRODUCTOS ---");

        if (productos.isEmpty()) {
            System.out.println("No hay productos cargados.");
            return;
        }

        for (Producto producto : productos) {
            System.out.println(producto);
            System.out.println("Detalle específico: " + producto.getDetalleEspecifico());
            //System.out.println("Precio final calculado: " + producto.calcularPrecioFinal());
            System.out.println("--------------------------------------------");
        }
    }

    public static void consultarProducto(Scanner scanner, ArrayList<Producto> productos) {
        System.out.println("\n--- CONSULTAR PRODUCTO ---");

        if (productos.isEmpty()) {
            System.out.println("No hay productos cargados.");
            return;
        }

        System.out.println("1 - Buscar por código.");
        System.out.println("2 - Buscar por nombre de producto.");

        int opcionElegida = IngresarNro.leerEntero(scanner, "Ingrese una opción: ");
        Producto producto;

        if (opcionElegida == 1) {
            int codigo = IngresarNro.leerEntero(scanner, "Ingrese el código del producto a consultar: ");
            producto = buscarProductoPorCodigo(productos, codigo);
        }
        else if (opcionElegida == 2) {
            String nombre = IngresarTexto.leerTextoNoVacio(scanner, "Ingrese el nombre del producto a consultar: ");
            producto = buscarProductoPorNombre(productos, nombre);
        }
        else {
            System.out.println("Opción elegida no válida.");
            return;
        }

        if (producto == null) {
            System.out.println("El producto no existe.");
            return;
        }

        System.out.println("Producto encontrado:");
        System.out.println(producto);
        System.out.println("Detalle específico: " + producto.getDetalleEspecifico());
        //System.out.println("Precio final calculado: " + producto..calcularPrecioFinal());
    }

    public static Producto buscarProductoPorCodigo(ArrayList<Producto> productos, int codigo) {
        for (Producto producto : productos) {
            if (producto.getCodigo() == codigo) {
                return producto;
            }
        }
        return null;
    }

    public static Producto buscarProductoPorNombre(ArrayList<Producto> productos, String nombre) {
        for (Producto producto : productos) {
            //Ojo. Nunca comparar Sgrings con == porque compara referencias en memoria.
            if (producto.getNombre().equals(nombre) ) {
                return producto;
            }
        }
        return null;
    }

    public static void modificarProducto(
            Scanner scanner,
            ArrayList<Producto> productos,
            ArrayList<Categoria> categorias
    ) {
        System.out.println("\n--- MODIFICAR PRODUCTO ---");

        if (productos.isEmpty()) {
            System.out.println("No hay productos cargados.");
            return;
        }

        int codigo = IngresarNro.leerEntero(scanner, "Ingrese el código del artículo a modificar: ");

        Producto producto = buscarProductoPorCodigo(productos, codigo);

        if (producto == null) {
            System.out.println("El producto no existe.");
            return;
        }

        String nuevoNombre = IngresarTexto.leerTextoNoVacio(scanner, "Ingrese el nuevo nombre del artículo: ");
        double nuevoPrecio = IngresarNro.leerEntero(scanner, "Ingrese el nuevo precio del artículo: ");
        int nuevaCantidad = IngresarNro.leerEntero(scanner, "Ingrese la nueva cantidad en stock:");

        Categoria.listarCategorias(categorias);
        Categoria nuevaCategoria = Categoria.buscarCategoriaPorCodigo(categorias, codigo);

        producto.setNombre(nuevoNombre);
        producto.setPrecio(nuevoPrecio);
        producto.setCantidad(nuevaCantidad);
        producto.setCategoria(nuevaCategoria);

        /*if (producto instanceof ProductoElectronico) {
            ProductoElectronico electronico = (PrductoElectronico) producto;
            int nuevaGarantia = IngresarNro.leerEnteroNoNegativo(scanner, "Ingrese la nueva garantía en meses: ");
            electronico.setGarantiaMeses(nuevaGarantia);
        }

        if (producto instanceof ProductoAlimenticio) {
            ProductoAlimenticio alimenticio = (ProductoAlimenticio) producto;
            int nuevosDias = IngresarNro.leerEntero(scanner, "Ingrese los nuevos días para vencimiento: ");
            alimenticio.setDiasParaVencimiento(nuevosDias);
        }*/

        System.out.println("Artículo modificado correctamente.");
        //System.out.println("Nuevo precio final: " + articulo.calcularPrecioFinal());
    }

    public static void eliminarProducto(Scanner scanner, ArrayList<Producto> productos) {
        System.out.println("\n--- ELIMINAR PRODUCTO ---");

        if (productos.isEmpty()) {
            System.out.println("No hay productos cargados.");
            return;
        }

        int codigo = IngresarNro.leerEntero(scanner, "Ingrese el código del producto a eliminar: ");

        Producto producto = buscarProductoPorCodigo(productos, codigo);

        if (producto == null) {
            System.out.println("El producto no existe.");
            return;
        }

        Character confirma = IngresarTexto.leerConfirmacionNoVacia(scanner, "¿Confirma la eliminación del producto "+producto.getNombre()+"?. (S/N): ");

        if (confirma == 'S') {
            productos.remove(producto);
            System.out.println("Producto "+ producto.getNombre()+" eliminado correctamente.");
        }
    }

}
