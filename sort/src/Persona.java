// Clase 1: Persona.java
// Puedes reemplazar esta clase por cualquier entidad como Producto, Empleado, Estudiante, etc.
public class Persona {
    private String nombre;
    private int id;

    public Persona(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "(" + nombre + ", " + id + ")";
    }
}
