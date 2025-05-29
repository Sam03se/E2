// 🧠 Interfaz Estrategia Genérica de Búsqueda
public interface BusquedaEstrategiaGenerica<T> {
    int buscar(T[] datos, T objetivo);
}

/*
📌 Esta interfaz permite intercambiar cualquier algoritmo de búsqueda sin cambiar el resto del código.

🔧 EJEMPLOS DE CASO:
- Puedes tener clases como BusquedaLinealGenerica, BusquedaBinariaGenerica, etc.
- Puedes extender para búsquedas personalizadas según tus necesidades (por edad, texto parcial, etc.)
*/
