
package ejerciciopracticasjunio;
public class Producto {
  private static int incrementadorIds = 0;
  private int idProducto;
  private String nombreProducto;
  private double precio;

  public int getIdProducto() {
    return idProducto;
  }
  public String getNombreProducto() {
    return nombreProducto;
  }
  public double getPrecio() {
    return precio;
  }
  public Producto(String nombre, double precio) {
    this.nombreProducto = nombre;
    this.precio = precio;
    idProducto = ++incrementadorIds;
  } 
}
