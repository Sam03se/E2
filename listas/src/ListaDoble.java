import java.util.ArrayList;
import java.util.List;

// Lista doblemente enlazada personalizada
public class ListaDoble implements Lista {

    private class Nodo {
        Producto dato;
        Nodo anterior;
        Nodo siguiente;

        Nodo(Producto dato) {
            this.dato = dato;
            this.anterior = null;
            this.siguiente = null;
        }
    }

    private Nodo primero;
    private Nodo ultimo;

    public ListaDoble() {
        primero = null;
        ultimo = null;
    }

    @Override
    public void insertar(Producto p) {
        Nodo nuevo = new Nodo(p);
        if (primero == null) {
            primero = ultimo = nuevo;
        } else {
            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;
            ultimo = nuevo;
        }
    }

    @Override
    public void mostrar() {
        Nodo actual = primero;
        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }
    }

    @Override
    public List<Producto> obtenerLista() {
        List<Producto> lista = new ArrayList<>();
        Nodo actual = primero;
        while (actual != null) {
            lista.add(actual.dato);
            actual = actual.siguiente;
        }
        return lista;
    }
}
