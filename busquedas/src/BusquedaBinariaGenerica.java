// 🎯 Búsqueda Binaria Genérica (para datos ordenados)
public class BusquedaBinariaGenerica<T extends Comparable<T>> implements BusquedaEstrategiaGenerica<T> {
    @Override
    public int buscar(T[] datos, T objetivo) {
        int inicio = 0;
        int fin = datos.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            int comparacion = datos[medio].compareTo(objetivo);

            if (comparacion == 0) return medio;
            if (comparacion < 0) inicio = medio + 1;
            else fin = medio - 1;
        }
        return -1; // ❌ No encontrado
    }
}

/*
📌 USO TÍPICO:
- Cuando los datos están ordenados (por código, ID, etc.)
- Funciona con cualquier clase que implemente Comparable<T>

🔧 EJEMPLOS DE CASO:
- Buscar un producto por su código numérico
- Buscar un estudiante por número de matrícula ordenado
*/
