// 📈 Búsqueda Interpolada (sólo para códigos numéricos distribuidos)
public class BusquedaInterpoladaProducto implements BusquedaEstrategiaGenerica<Producto> {
    @Override
    public int buscar(Producto[] datos, Producto objetivo) {
        int inicio = 0;
        int fin = datos.length - 1;
        int objetivoCodigo = objetivo.getCodigo();

        while (inicio <= fin && objetivoCodigo >= datos[inicio].getCodigo() && objetivoCodigo <= datos[fin].getCodigo()) {
            int pos = inicio + (objetivoCodigo - datos[inicio].getCodigo()) * (fin - inicio)
                    / (datos[fin].getCodigo() - datos[inicio].getCodigo());

            int codigoActual = datos[pos].getCodigo();

            if (codigoActual == objetivoCodigo) return pos;
            if (codigoActual < objetivoCodigo) inicio = pos + 1;
            else fin = pos - 1;
        }
        return -1; // ❌ No encontrado
    }
}

/*
📌 USO TÍPICO:
- Cuando los códigos están uniformemente distribuidos (por ejemplo: 100, 110, 120...)
- Similar a la binaria pero con estimación de posición

🔧 EJEMPLOS DE CASO:
- Búsqueda optimizada de productos en inventarios grandes y ordenados
- Sistema bancario que gestiona IDs numéricos secuenciales
*/
