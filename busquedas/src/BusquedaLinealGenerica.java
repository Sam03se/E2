// 🔍 Búsqueda Lineal Genérica
public class BusquedaLinealGenerica<T> implements BusquedaEstrategiaGenerica<T> {
    @Override
    public int buscar(T[] datos, T objetivo) {
        for (int i = 0; i < datos.length; i++) {
            if (datos[i].equals(objetivo)) {
                return i; // ✅ Encontrado
            }
        }
        return -1; // ❌ No encontrado
    }
}

/*
📌 USO TÍPICO:
- Cuando los datos NO están ordenados
- Para buscar objetos con equals personalizado (Producto, Usuario, etc.)
- Ideal en arreglos pequeños

🔧 EJEMPLOS DE CASO:
- Buscar una bebida por nombre
- Buscar una matrícula de estudiante
- Verificar existencia de una cédula o ID
*/