// 🎮 Controlador genérico para gestionar una lista de EntidadRecursivaBase
import java.util.ArrayList;
import java.util.List;

public class ControladorEntidadRecursiva {
    private List<EntidadRecursivaBase> listaEntidades = new ArrayList<>();

    // ➕ Agregar una nueva entidad raíz
    public void agregarEntidad(EntidadRecursivaBase entidad) {
        listaEntidades.add(entidad);
    }

    // 🔍 Buscar entidad raíz por ID
    public EntidadRecursivaBase buscarPorId(String id) {
        for (EntidadRecursivaBase e : listaEntidades) {
            if (e.getId().equalsIgnoreCase(id)) return e;
        }
        return null;
    }

    // 📃 Obtener todas las entidades raíz
    public List<EntidadRecursivaBase> getListaEntidades() {
        return listaEntidades;
    }

    // ✏️ Editar valor base de una entidad específica
    public void modificarValor(String id, double nuevoValor) {
        EntidadRecursivaBase entidad = buscarPorId(id);
        if (entidad != null) {
            entidad.setValorBase(nuevoValor);
        }
    }

    // 🧾 Calcular valor total de una entidad raíz (recursivo)
    public double calcularTotal(String id) {
        EntidadRecursivaBase entidad = buscarPorId(id);
        if (entidad != null) {
            return entidad.calcularValorTotal();
        }
        return 0;
    }
}
