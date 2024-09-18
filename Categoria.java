import java.util.ArrayList;
import java.util.Random;

public class Categoria {
    public int id;
    public String nombre;
    public ArrayList<Producto> listaProductos = new ArrayList<Producto>();
    public Random random = new Random();

    public Categoria(String nombre) {
        this.id = this.random.nextInt(1, 10001);
        this.nombre = nombre;
    }

    public void registrarProductoEnCategoria(Producto producto) {
        this.listaProductos.add(producto);
    }

    public void mostrarCategoria() {
        String datos = String.format("Id: %d, nombre: %s", this.id, this.nombre);
        System.out.println(datos);
    }

    public void mostrarCategoriaConProductos() {
        System.out.println("\nCategoría: " + this.nombre);
        System.out.println("Id: " + this.id);

        if (this.listaProductos.size() == 0) {
            System.out.println("Productos existentes: 0");
            return;
        }

        System.out.println("Productos existentes en la categoría");
        for (Producto producto : this.listaProductos) {
            System.out.println(producto.mostrarProducto());
        }
    }
}
