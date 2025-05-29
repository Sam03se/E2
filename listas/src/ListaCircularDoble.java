import java.util.ArrayList;
import java.util.List;

// Lista circular doblemente enlazada personalizada
public class ListaCircularDoble implements Lista {

    private class Nodo {
        Producto dato;
        Nodo siguiente;
        Nodo anterior;

        Nodo(Producto dato) {
            this.dato = dato;
            this.siguiente = this;
            this.anterior = this;
        }
    }

    private Nodo primero;

    public ListaCircularDoble() {
        primero = null;
    }

    @Override
    public void insertar(Producto p) {
        Nodo nuevo = new Nodo(p);
        if (primero == null) {
            primero = nuevo;
        } else {
            Nodo ultimo = primero.anterior;
            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;
            nuevo.siguiente = primero;
            primero.anterior = nuevo;
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
