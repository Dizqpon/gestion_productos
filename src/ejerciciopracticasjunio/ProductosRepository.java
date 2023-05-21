/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciopracticasjunio;
public class ProductosRepository {

  private static Producto[] productos = new Producto[150];

  public void insertarProducto(String nombreProducto, double precioProducto) {
    Producto producto = new Producto(nombreProducto, precioProducto);
    int index = buscarPrimerNulo(productos);
    if (index != -1) {
      productos[index] = producto;
    } else {
      System.out.println("No hay espacio disponible para agregar el producto.");
    }
  }
  public void insertarProductos(String nombreProducto, double precioProducto, int cantidadProductos) {
    for (int i = 0; i < cantidadProductos; i++) {
      insertarProducto(nombreProducto, precioProducto);
    }
  }
  public void extraerProducto(int id) {
    for (int i = 0; i < productos.length; i++) {
      Producto producto = productos[i];
      if (producto != null && producto.getIdProducto() == id) {
        productos = quitarProducto(productos, i);
        break; // Salir del bucle una vez que se haya eliminado el producto
      }
    }
  }
  private static Producto[] quitarProducto(Producto[] arr, int indice) {
    Producto[] result = new Producto[arr.length - 1];
    System.arraycopy(arr, 0, result, 0, indice);
    if (arr.length != indice) {
      System.arraycopy(arr, indice + 1, result, indice, arr.length - indice - 1);
    }
    return result;
  }
  public String buscarProducto(int id) {
    String msg = "El ID introducido no corresponde a ningún producto del stock";
    for (Producto producto : productos) {
      if (producto != null) {
        if (producto.getIdProducto() == id) {
          msg = "Producto Buscado\n----------------\n Nombre: "
            + producto.getNombreProducto() + "\n Precio: "
            + producto.getPrecio() + "\n Stock: "
            + manejoStock(producto) + "\n";
        }
      }
    }
    return msg;
  }
  public void listarProductos() {
    System.out.println("***** LISTA DE PRODUCTOS EN STOCK *****\n-----------------------------------");
    for (Producto producto : productos) {
      if (producto != null) {
        mostrarProducto(producto);
      }
    }
  }
  public void listarProductosBajoStock() {
    System.out.println("***** LISTA DE PRODUCTOS DE STOCK BAJO *****\n--------------------------------------");
    for (Producto producto : productos) {
      if (manejoStock(producto) < 5) {
        mostrarProducto(producto);
        System.out.println();
      }
    }
  }
  private static void mostrarProducto(Producto p) {
    System.out.println("Producto " + p.getIdProducto()
      + "\n Nombre: " + p.getNombreProducto()
      + "\n Precio: " + p.getPrecio() + "\n Stock: "
      + manejoStock(p) + "\n");
  }
  private int buscarPrimerNulo(Producto[] arr) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == null) {
        return i;
      }
    }
    return -1;
  }
  public static int manejoStock(Producto p) {
    int stock = 0;
    for (Producto prod : productos) {
      if (prod != null && p.getNombreProducto().equals(prod.getNombreProducto())) {
        stock++;
      }
    }
    return stock;
  }
}
