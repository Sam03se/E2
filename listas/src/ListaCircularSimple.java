import java.util.ArrayList;
import java.util.List;

// Lista circular simple personalizada
public class ListaCircularSimple implements Lista {

    private class Nodo {
        Producto dato;
        Nodo siguiente;

        Nodo(Producto dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo primero;

    public ListaCircularSimple() {
        primero = null;
    }

    @Override
    public void insertar(Producto p) {
        Nodo nuevo = new Nodo(p);
        if (primero == null) {
            primero = nuevo;
            nuevo.siguiente = primero;
        } else {
            Nodo actual = primero;
            while (actual.siguiente != primero) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
            nuevo.siguiente = primero;
        }
    }

    @Override
    public void mostrar() {
        if (primero == null) return;
        Nodo actual = primero;
        do {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        } while (actual != primero);
    }

    @Override
    public List<Producto> obtenerLista() {
        List<Producto> lista = new ArrayList<>();
        if (primero == null) return lista;
        Nodo actual = primero;
        do {
            lista.add(actual.dato);
            actual = actual.siguiente;
        } while (actual != primero);
        return lista;
    }
}
