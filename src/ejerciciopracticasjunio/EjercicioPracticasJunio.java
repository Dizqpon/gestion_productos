/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciopracticasjunio;

import java.util.Scanner;

public class EjercicioPracticasJunio {
  public static void main(String[] args) {
    String nombreProductoUsuario;
    double precioProductoUsuario;
    boolean siguiente = true;
    int seleccionUsuario;
    Scanner sc = new Scanner(System.in);
    ProductosRepository repositorioStock = new ProductosRepository();

    while (siguiente) {
      System.out.println("1.- Cargar productos (al menos 4) en el programa automáticamente.");
      System.out.println("2.- Agregar un producto.");
      System.out.println("3.- Buscar un producto.");
      System.out.println("4.- Eliminar un producto.");
      System.out.println("5.- Mostrar productos (todos).");
      System.out.println("6.- Productos con Stock bajo (los que su cantidad sean menor de 5).");
      System.out.println("7.- Salir de la aplicación.");
      seleccionUsuario = sc.nextInt();

      switch (seleccionUsuario) {
        case 1:
          System.out.println("Introduzca el nombre del producto");
          nombreProductoUsuario = sc.next();
          System.out.println("Introduzca el precio del producto");
          precioProductoUsuario = sc.nextDouble();
          System.out.println("Introduzca cuantas unidades del producto mete en Stock");
          int cantidad = sc.nextInt();
          if (cantidad >= 4) {
            repositorioStock.insertarProductos(nombreProductoUsuario, precioProductoUsuario, cantidad);
          } else {
            System.out.println("El número de productos introducidos de una vez debe ser mayor que 4");
          }
          break;
        case 2:
          System.out.println("Introduzca el nombre del producto");
          nombreProductoUsuario = sc.next();
          System.out.println("Introduzca el precio del producto");
          precioProductoUsuario = sc.nextDouble();
          repositorioStock.insertarProducto(nombreProductoUsuario, precioProductoUsuario);
          break;
        case 3:
          System.out.println("Introduzca el ID del producto que desea buscar");
          System.out.println(repositorioStock.buscarProducto(sc.nextInt()));
          break;
        case 4:
          System.out.println("Introduzca el ID del producto que desea eliminar");
          repositorioStock.extraerProducto(sc.nextInt());
          break;
        case 5:
          repositorioStock.listarProductos();
          break;
        case 6:
          repositorioStock.listarProductosBajoStock();
          break;
        case 7:
          System.exit(0);
          break;
        default:
          throw new AssertionError();
      }
    }
  }
}
