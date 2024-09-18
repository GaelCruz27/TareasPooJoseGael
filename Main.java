import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();

        int opcion = 0;

        while (opcion != 7) {
            System.out.println("\n*** BIENVENIDO ***");
            System.out.println("1. Registrar producto");
            System.out.println("2. Eliminar producto");
            System.out.println("3. Mostrar productos");
            System.out.println("4. Registrar categoría");
            System.out.println("5. Mostrar categorías");
            System.out.println("6. Mostrar categorías con productos");
            System.out.println("7. Salir");

            System.out.println("Selecciona una opción: ");
            opcion = scanner.nextInt();

            scanner.nextLine();

            switch (opcion) {
                case 1:
                    if (!inventario.validarExistenciaDeCategorias()) {
                        System.out.println("\nNo existen categorías en el sistema");
                        break;
                    }

                    System.out.println("\nSeleccionaste la opción para registrar un producto");

                    System.out.println("Ingresa el nombre del producto");
                    String nombre = scanner.nextLine();

                    System.out.println("Ingresa el precio del producto");
                    double precio = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Ingresa la descripción del producto");
                    String descripcion = scanner.nextLine();

                    System.out.println("Ingresa el id de la categoría en cual registrarás el producto: ");
                    int idCategoria = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Ingresa el stock del producto");
                    int stock = scanner.nextInt();
                    scanner.nextLine();

                    Producto producto = new Producto(nombre, precio, descripcion, idCategoria, stock);
                    inventario.registrarProducto(producto);

                    System.out.println("\nProducto registrado correctamente");
                    break;
                case 2:
                    System.out.println("\nSeleccionaste la opción para eliminar un producto");

                    System.out.println("Ingresa el ID del producto: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    inventario.eliminarProducto(id);
                    break;
                case 3:
                    inventario.mostrarProductos();
                    break;
                case 4:
                    System.out.println("\nSeleccionaste la opción para registrar una categoría");

                    System.out.println("Ingresa el nombre de la categoría: ");
                    String nombreCategoria = scanner.nextLine();

                    Categoria categoria = new Categoria(nombreCategoria);
                    inventario.registrarCategoria(categoria);

                    System.out.println("\nCategoría registrada correctamente");
                    break;
                case 5:
                    inventario.mostrarCategorias();
                    break;
                case 6:
                    inventario.mostrarCategoriasConProductos();
                    break;
                case 7:
                    System.out.println("Hasta luego");
                    return;
            }
        }
    }
}
