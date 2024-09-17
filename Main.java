import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Producto producto = new Producto("Ejemplo", 10.0, 5);

        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Mostrar información del producto");
            System.out.println("2. Aumentar stock");
            System.out.println("3. Reducir stock");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    producto.mostrarInformacion();
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad a aumentar: ");
                    int cantidadAumentar = scanner.nextInt();
                    producto.aumentarStock(cantidadAumentar);
                    break;
                case 3:
                    System.out.print("Ingrese la cantidad a reducir: ");
                    int cantidadReducir = scanner.nextInt();
                    producto.reducirStock(cantidadReducir);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}