import java.util.ArrayList;
import java.util.List;

// Implementa la interfaz Lista usando una ArrayList interna.
// Puedes copiar esta clase para hacer ListaDoble, ListaCircular, etc.
public class ListaSimple implements Lista {
    private List<Producto> lista;

    public ListaSimple() {
        lista = new ArrayList<>();
    }

    @Override
    public void insertar(Producto p) {
        lista.add(p);
        // Puedes agregar validaciones aquí: por ejemplo, que no se repita el ID
    }

    @Override
    public void mostrar() {
        if (lista.isEmpty()) {
            System.out.println("La lista está vacía.");
            return;
        }
        for (Producto p : lista) {
            System.out.println(p);
        }
    }

    @Override
    public List<Producto> obtenerLista() {
        return lista;
    }
}
