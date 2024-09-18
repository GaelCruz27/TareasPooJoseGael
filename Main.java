import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();

        int opcion = 0;

        while (opcion != 6) {
            System.out.println("\n*** BIEVENIDO ***");
            System.out.println("1. Registrar producto");
            System.out.println("2. Eliminar producto");
            System.out.println("3. Mostrar productos");
            System.out.println("4. Listar categorías");
            System.out.println("5. Listar categorías con productos");
            System.out.println("6. Salir");

            System.out.println("Selecciona una opción: ");
            opcion = scanner.nextInt();

            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\nSeleccionaste la opción para registrar un producto");

                    System.out.println("Ingresa el nombre del producto");
                    String nombre = scanner.nextLine();

                    System.out.println("Ingresa el precio del producto");
                    double precio = scanner.nextDouble();

                    scanner.nextLine();

                    System.out.println("Ingresa la descripción del producto");
                    String descripcion = scanner.nextLine();

                    System.out.println("Ingresa el ID de la categoría del producto");
                    int categoriaId = scanner.nextInt();

                    if (!inventario.categoriaExiste(categoriaId)) {
                        System.out.println("No existe una categoría con el ID ingresado. Intenta de nuevo.");
                        break;
                    }

                    System.out.println("Ingresa el stock del producto");
                    int stock = scanner.nextInt();

                    Producto producto = new Producto(nombre, precio, descripcion, categoriaId, stock);
                    inventario.registrarProducto(producto);

                    System.out.println("\nProducto registrado correctamente");
                    break;
                case 2:
                    System.out.println("\nSeleccionaste la opción para eliminar un producto");

                    System.out.println("Ingresa el ID del producto: ");
                    int id = scanner.nextInt();

                    inventario.eliminarProducto(id);
                    break;
                case 3:
                    inventario.mostrarProductos();
                    break;
                case 4:
                    inventario.listarCategorias();
                    break;
                case 5:
                    inventario.listarCategoriasConProductos();
                    break;
                case 6:
                    System.out.println("Hasta luego");
                    return;
            }
        }
    }
}
