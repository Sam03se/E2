// Controlador genérico: maneja CRUD para cualquier tipo de entidad base
import java.util.*;

public class ControladorEntidad {
    private List<EntidadBase> lista = new ArrayList<>(); // Lista genérica adaptable

    public void agregarEntidad(EntidadBase e) {
        lista.add(e); // Añadir entidad (Agente, Estudiante, Producto...)
    }

    public EntidadBase buscarPorId(String id) {
        for (EntidadBase e : lista) {
            if (e.getId().equalsIgnoreCase(id)) return e;
        }
        return null; // Si no existe
    }

    public List<EntidadBase> getLista() {
        return lista;
    }

    public void modificarEntidad(String id, double nuevoValor) {
        EntidadBase e = buscarPorId(id);
        if (e != null) e.setValorBase(nuevoValor);
    }
}
