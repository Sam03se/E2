// 📦 Clase Producto: objeto base para aplicar búsquedas
public class Producto implements Comparable<Producto> {
    private String nombre;
    private int codigo;
    private double precio;

    public Producto(String nombre, int codigo, double precio) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "[" + codigo + "] " + nombre + " - $" + precio;
    }

    @Override
    public int compareTo(Producto o) {
        return Integer.compare(this.codigo, o.codigo); // Comparación por código
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Producto) {
            Producto otro = (Producto) obj;
            return this.codigo == otro.codigo || this.nombre.equalsIgnoreCase(otro.nombre);
        }
        return false;
    }
}

/*
📌 CASOS DE USO:
- Inventarios
- Catálogos de productos
- Listados de estudiantes o personas con ID numérico y nombre
*/
