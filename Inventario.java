import java.util.ArrayList;

public class Inventario {
   public ArrayList<Producto> listaProductos = new ArrayList<Producto>();
   public ArrayList<Categoria> listaCategorias = new ArrayList<Categoria>();

   public Inventario() {
       // Agregar algunas categorías de ejemplo
       listaCategorias.add(new Categoria(1, "Electrónica"));
       listaCategorias.add(new Categoria(2, "Ropa"));
       listaCategorias.add(new Categoria(3, "Alimentos"));
   }

   public void registrarProducto(Producto producto) {
      this.listaProductos.add(producto);
   }

   public void eliminarProducto(int idProductoEliminar) {
      int longitudOriginal = this.listaProductos.size();

      this.listaProductos.removeIf((producto) -> producto.getId() == idProductoEliminar);

      if (longitudOriginal != this.listaProductos.size()) {
         System.out.println("Se eliminó el producto con el ID: " + idProductoEliminar);
      } else {
         System.out.println("No existe un producto con el ID: " + idProductoEliminar);
      }
   }

   public void mostrarProductos() {
      System.out.println("\n*** PRODUCTOS EN EL SISTEMA ***");

      if (this.listaProductos.size() == 0) {
         System.out.println("\nNo existen productos en el sistema");
         return;
      }

      int iterador = 1;
      for (Producto producto : this.listaProductos) {
         System.out.println("\nEste es el producto: " + iterador);
         System.out.println(producto.mostrarProducto());
         iterador++;
      }
   }

   public void listarCategorias() {
      System.out.println("\n*** CATEGORÍAS EN EL SISTEMA ***");

      if (this.listaCategorias.size() == 0) {
         System.out.println("\nNo existen categorías en el sistema");
         return;
      }

      for (Categoria categoria : this.listaCategorias) {
         System.out.println("ID: " + categoria.getId() + ", Nombre: " + categoria.getNombre());
      }
   }

   public void listarCategoriasConProductos() {
      System.out.println("\n*** CATEGORÍAS CON PRODUCTOS ***");

      if (this.listaCategorias.size() == 0) {
         System.out.println("\nNo existen categorías en el sistema");
         return;
      }

      for (Categoria categoria : this.listaCategorias) {
         System.out.println("ID: " + categoria.getId() + ", Nombre: " + categoria.getNombre());
         for (Producto producto : this.listaProductos) {
            if (producto.getCategoriaId() == categoria.getId()) {
               System.out.println("  - " + producto.mostrarProducto());
            }
         }
      }
   }

   public boolean categoriaExiste(int idCategoria) {
      for (Categoria categoria : this.listaCategorias) {
         if (categoria.getId() == idCategoria) {
            return true;
         }
      }
      return false;
   }
}
