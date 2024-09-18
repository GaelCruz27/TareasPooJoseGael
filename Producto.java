import java.util.Random;

public class Producto {
    public int id;
    public String nombre;
    public Double precio;
    public String descripcion;
    public int categoriaId;
    public int stock;
    public Random random = new Random();

    public Producto(String nombre, Double precio, String descripcion, int categoriaId, int stock) {
        this.id = this.random.nextInt(1, 10001);
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.categoriaId = categoriaId;
        this.stock = stock;
    }
    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public int getStock() {
        return stock;
    }

    public String mostrarProducto() {
        return String.format("Id: %d, nombre: %s, precio: %.2f, descripción: %s, categoría ID: %d, stock: %d",
                id,
                nombre,
                precio,
                descripcion,
                categoriaId,
                stock
        );
    }
}
