// Clase Producto: puedes agregar más atributos como IVA, fecha, categoría, etc.
public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int cantidad;

    // Constructor base. Puedes agregar más parámetros si el caso lo requiere.
    public Producto(int id, String nombre, double precio, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Getters: usa estos para ordenamiento, búsqueda o mostrar
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getCantidad() { return cantidad; }

    // Método que define cómo se imprime el producto (útil en consola o en tabla Swing)
    @Override
    public String toString() {
        return String.format("ID: %d | Nombre: %s | Precio: %.2f | Cantidad: %d", id, nombre, precio, cantidad);
    }
}
