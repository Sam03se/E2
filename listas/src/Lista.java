import java.util.List;

// Esta interfaz permite que cualquier tipo de lista implemente los métodos base.
// Así puedes cambiar ListaSimple por ListaDoble sin tocar SistemaProductos.
public interface Lista {
    void insertar(Producto p);
    void mostrar();
    List<Producto> obtenerLista(); // Necesaria para ordenamiento y búsqueda avanzada
}
