import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Producto> productos = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;
        int indice;
        do {
            System.out.println("=== Menú principal ===");
            System.out.println("1. Añadir producto");
            System.out.println("2. Borrar producto");
            System.out.println("3. Modificar producto");
            System.out.println("4. Ver listado de productos");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1 -> {
                    aniadirProducto();
                }
                case 2 -> {
                    borrarProducto();
                }
                case 3 -> this.opcion3();
                case 4 -> this.opcion4();
                case 5 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción no válida");
            }
        } while (opcion != 5);
    }

    public static void opcion3(){
        System.out.print("Índice del producto a modificar: ");
        indice = scanner.nextInt();
        scanner.nextLine();
        if (int indice < 0 || indice >= productos.size()) {
            System.out.println("Índice no válido");
        } else {
            System.out.print("Nuevo nombre del producto (deja vacío para no modificar): ");
            String nuevoNombre = scanner.nextLine();
            System.out.print("Nuevo precio del producto (deja 0 para no modificar): ");
            double nuevoPrecio = scanner.nextDouble();
            scanner.nextLine();
            Producto productoAModificar = productos.get(indice);
            if (!nuevoNombre.isEmpty()) {
                productoAModificar.setNombre(nuevoNombre);
            }
            if (nuevoPrecio != 0) {
                productoAModificar.setPrecio(nuevoPrecio);
            }

            System.out.println("Producto modificado correctamente");
        }
    }

    public static void opcion4(){
        System.out.println("=== Listado de productos ===");
        for (int index = 0; index < productos.size(); index++) {
            Producto productoAMostrar = productos.get(index);
            System.out.println(index + ". " + productoAMostrar.getNombre() + " - $" + productoAMostrar.getPrecio());
        }

        System.out.println("============================");
    }

    public static void aniadirProducto(){
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Precio del producto: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();
        Producto producto = new Producto(nombre, precio);
        productos.add(producto);
        System.out.println("Producto añadido correctamente");
    }

    public static void borrarProducto(){
        System.out.print("Índice del producto a borrar: ");
                    indice = scanner.nextInt();
                    scanner.nextLine();
        if (indice < 0 || indice >= productos.size()) {
            System.out.println("Índice no válido");
        } else {
             productos.remove(indice);
            System.out.println("Producto borrado correctamente");
        }
    }

}