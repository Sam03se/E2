import java.util.*;

public class SistemaProductos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Lista lista = null;

        // Paso 1: Selección del tipo de lista
        System.out.println("=== SELECCIÓN DE TIPO DE LISTA ===");
        System.out.println("1. Lista Simple");
        System.out.println("2. Lista Doble");
        System.out.println("3. Lista Circular Simple");
        System.out.println("4. Lista Circular Doble");
        System.out.print("Selecciona la estructura que deseas usar: ");
        int tipo = sc.nextInt();

        switch (tipo) {
            case 1 -> lista = new ListaSimple();
            case 2 -> lista = new ListaDoble();
            case 3 -> lista = new ListaCircularSimple();
            case 4 -> lista = new ListaCircularDoble();
            default -> {
                System.out.println("Opción inválida. Se usará Lista Simple por defecto.");
                lista = new ListaSimple();
            }
        }

        // Menú principal
        while (true) {
            System.out.println("\n=== MENÚ DEL SISTEMA DE PRODUCTOS ===");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Ordenar productos");
            System.out.println("4. Buscar por ID");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            int op = sc.nextInt();

            switch (op) {
                case 1 -> {
                    // Puedes agregar lógica adicional para IVA, validaciones, etc.
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();
                    System.out.print("Cantidad: ");
                    int cantidad = sc.nextInt();

                    Producto nuevo = new Producto(id, nombre, precio, cantidad);
                    lista.insertar(nuevo);
                    System.out.println("Producto agregado correctamente.");
                }

                case 2 -> {
                    System.out.println("Lista de productos:");
                    lista.mostrar();
                }

                case 3 -> {
                    System.out.println("Ordenar por:");
                    System.out.println("1. ID");
                    System.out.println("2. Nombre");
                    System.out.println("3. Precio");
                    System.out.println("4. Cantidad");
                    System.out.print("Criterio: ");
                    int criterio = sc.nextInt();

                    List<Producto> productos = lista.obtenerLista();

                    switch (criterio) {
                        case 1 -> productos.sort(Comparadores.porId);
                        case 2 -> productos.sort(Comparadores.porNombre);
                        case 3 -> productos.sort(Comparadores.porPrecio);
                        case 4 -> productos.sort(Comparadores.porCantidad);
                        default -> System.out.println("Criterio inválido.");
                    }

                    System.out.println("Productos ordenados:");
                    for (Producto p : productos) {
                        System.out.println(p);
                    }
                }

                case 4 -> {
                    System.out.print("ID a buscar: ");
                    int idBuscar = sc.nextInt();
                    boolean encontrado = false;
                    for (Producto p : lista.obtenerLista()) {
                        if (p.getId() == idBuscar) {
                            System.out.println("Producto encontrado: " + p);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) System.out.println("Producto no encontrado.");
                }

                case 5 -> {
                    System.out.println("Saliendo del sistema. ¡Gracias!");
                    return;
                }

                default -> System.out.println("Opción inválida.");
            }
        }
    }
}
