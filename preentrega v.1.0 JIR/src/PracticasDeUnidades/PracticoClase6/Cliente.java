package PracticasDeUnidades.PracticoClase6;

public class Cliente {
    //Atributos
    private String nombre;
    private String email;

    //Cosntructores
    // Constructor con parámetros
    public Cliente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    //Métodos
    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public boolean setNombre(String nombre) {
        boolean valido = nombreValido(nombre);
        if (valido) {
            this.nombre = nombre;
            return true;
        } else {
            System.out.print("Es un nombre, debe ingresar letras, no números ni vacío. Por favor, ingrese nombre: ");
            return false;
        }
    }

    public static boolean nombreValido(String texto) {
        if (texto == null || texto.isEmpty()) {
            return false; // O true, dependiendo si vacio es valido
        }
        // \\D busca cualquier caracter que NO sea un digito
        // !texto.matches(".*\\d.*") es equivalente a decir "no contiene digitos"
        return !texto.matches(".*\\d.*");
    }

    public boolean setEmail(String email) {
        if  (email instanceof String) {

            boolean contieneArroba = email.contains("@");
            boolean contienePunto = email.contains(".");

            if (contieneArroba) {
                if (contienePunto) {
                    this.email = email;
                    return true;
                } else {
                    System.out.print("El mail ingresado no contiene punto. Por favor, ingrese e-mail:");
                    return false;
                }
            } else {
                System.out.print("El mail ingresado no contiene @. Por favor, ingrese e-mail:");
                return false;
            }
        }
        else {
            System.out.println("Es un email, debe ingresar letras, no números");
            return false;
        }
    }

}

