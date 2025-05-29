// Comparadores: permiten ordenar por cualquier campo sin reescribir el código.
// Puedes crear más comparadores para ordenar por precio descendente, o con filtros.

import java.util.Comparator;

public class Comparadores {
    public static Comparator<Producto> porId = Comparator.comparingInt(Producto::getId);
    public static Comparator<Producto> porNombre = Comparator.comparing(Producto::getNombre);
    public static Comparator<Producto> porPrecio = Comparator.comparingDouble(Producto::getPrecio);
    public static Comparator<Producto> porCantidad = Comparator.comparingInt(Producto::getCantidad);
}
