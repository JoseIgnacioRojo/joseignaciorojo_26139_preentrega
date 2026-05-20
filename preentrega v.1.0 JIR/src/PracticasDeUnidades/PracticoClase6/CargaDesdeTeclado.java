package PracticasDeUnidades.PracticoClase6;

import java.util.Scanner;

public class CargaDesdeTeclado {
    Scanner sc = new Scanner(System.in);

    //Métodos
    public void cargaCliente() {
        System.out.print("Por favor, ingresá nombre de cliente: ");
        String nombreCliente = sc.nextLine();
        Cliente cli = new Cliente("1","1");
        Boolean esValido = cli.setNombre(nombreCliente);
        while (!esValido) {
            nombreCliente = sc.nextLine();
            esValido = cli.setNombre(nombreCliente);
        }
        System.out.print("Por favor, ingresá e-mail del cliente: ");
        String emailCliente = sc.nextLine();
        esValido = cli.setEmail(emailCliente);
        while (!esValido) {
            emailCliente = sc.nextLine();
            esValido = cli.setEmail(emailCliente);
        }
    }

    //Agrega stock
    public void cargaProductos() {
        Producto prod = new Producto("", 0.0, 0);
        String nombreProducto ="";
        double precio = 0.0;
        int stock = 0;
        Integer cantCreados = 0;
        Character continuarAlta = 'N';
        do {
            System.out.print("Por favor, ingresá nombre de producto: ");
            sc = new Scanner(System.in);
            nombreProducto = sc.nextLine();
            prod.setNombre(nombreProducto);

            System.out.print("Por favor, ingresá precio del producto: ");
            sc = new Scanner(System.in);
            precio = sc.nextDouble();
            //Validar que precio sea válido

            System.out.print("Por favor, ingresá cantidad de stock del producto: ");
            sc = new Scanner(System.in);
            stock = sc.nextInt();
            prod.setCantidad(stock);
            //Validar que stock sea válido

            prod = new Producto(nombreProducto,precio, stock);
            cantCreados = prod.setCantCreados(cantCreados);

            System.out.print("¿Desea continuar cargando productos.(S/N)?");
            sc = new Scanner(System.in);
            continuarAlta = sc.next().charAt(0);
        } while (continuarAlta == 'S');
        System.out.println("Cantidad de productos creados: "+prod.getCantCreados());
    }

    //Agrega productos al carrito
    public void agregaProductos() {
        Producto prod = new Producto("", 0.0, 0);
        Carrito changuito = new Carrito();
        String nombreProducto ="";
        double precio = 0.0;
        Integer cantidadAComprar = 0;
        Character continuarAlta = 'N';
        do {
            System.out.print("Por favor, ingresá nombre del producto a comprar: ");
            Scanner sc = new Scanner(System.in);
            nombreProducto = sc.nextLine();
            //Validar que el nombre de producto sea válido

            System.out.print("Por favor, ingresá precio del producto: ");
            sc = new Scanner(System.in);
            precio = sc.nextDouble();
            //Validar que precio sea válido

            System.out.print("Por favor, ingresá cantidad a comprar del producto: ");
            sc = new Scanner(System.in);
            cantidadAComprar = sc.nextInt();
            //Validar que sea cantidad válida

            prod = new Producto(nombreProducto,precio,cantidadAComprar);
            changuito.setProductosEnCarrito(prod);

            System.out.print("¿Desea continuar cargando productos.(S/N)?");
            continuarAlta = sc.next().charAt(0);
        } while (continuarAlta == 'S');
        changuito.calculaImporte();
    }
}
