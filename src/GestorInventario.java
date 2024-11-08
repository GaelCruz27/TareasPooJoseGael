import java.util.Scanner;

public class GestorInventario {
    public static void main(String[] args) {
        Producto producto = new Producto(null, 0, 0.0);
        Scanner leer = new Scanner(System.in);
        System.out.println("---    Gestor de Inventario    ---");
        do {
            System.out.println("Ingrese la operacion que desea realizar:");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Salir");
            try {
                int opcion = leer.nextInt();
                switch (opcion) {
                    case 1:

                        String nombre = ProductoInvalidoException();
                        int cantidad = CantidadInvalidaException();
                        double precio = PrecioInvalidoException();
                        Producto producto1 = new Producto(nombre, cantidad, precio);
                        producto.agregarProducto(producto1);
                        producto1.mostrarDatos();
                        break;
                    case 2:
                        producto.mostrarDetalles();
                        break;
                    case 3:
                        System.out.println("Saliendo...");
                        return;
                    default:
                        System.out.println("Error: Ingrese una opcion valida");
                }
            }catch (Exception error) {
                System.out.println("Error: Ingrese un numero valido");
                leer.nextLine();
            }
        }while (true);
    }
    public static String ProductoInvalidoException() throws Exception {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el nombre del producto:");
        String nombre = leer.next();
        if (nombre.isEmpty()){
            throw new Exception("Error: Producto invalido");
        } else {
            return nombre;
        }
    }

    public static double PrecioInvalidoException() throws Exception {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el precio del producto:");
        double precio = leer.nextDouble();
        if (precio <= 0){
            throw new Exception("Error: Precio invalido");
        } else {
            return precio;
        }

    }

    public static int CantidadInvalidaException() throws Exception {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese la cantidad del producto:");
        int cantidad = leer.nextInt();
        if (cantidad < 0){
            throw new Exception("Error: Cantidad invalida");
        } else {
            return cantidad;
        }
    }

}