package PracticasDeUnidades.PracticoClase7;

public class Main {

    public static void main(String[] args) {
        //Producto producto = new Producto(){
            //@Override
            //public void setProducto(Producto producto) {
                //super.setProducto(producto);
            //}
        //};
        //Productos productos = new ArrayList<Producto>();
        //ArrayList<Producto> productos = new ArrayList<>();
        //ArrayList<Producto> productos = new ArrayList<Productos>();

        //meto hardcodeado los productos que yo quiero
        Producto[] productos = {
                new Cafe(1, "Café Colombiano", 20, 1250.0, 400),
                new Cafe(2, "Café Turco", 12, 2250.0, 300),
                new Te (3, "Té negro", 50, 600.0, 50),
                new Te (4, "Té verde", 30, 800.0, 30)
        };

        //Recorró lo que metí hardcodeado
        int idProducto;
        String nombreProducto;
        for (Producto prod : productos) {
            idProducto = prod.getIdProducto();
            nombreProducto = prod.getNombreProducto();
            System.out.println(" ");
            System.out.print("Id:" + idProducto + ", Nombre de producto: " + nombreProducto);
            prod.calcularPrecioFinal();
        }

    }
}