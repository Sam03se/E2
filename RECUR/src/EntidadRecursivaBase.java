// 🧱 Clase base genérica para entidades recursivas (productos compuestos, servicios anidados, etc.)
import java.util.ArrayList;
import java.util.List;

public class EntidadRecursivaBase {
    private String id;                      // Identificador único de la entidad (producto, trámite, servicio...)
    private String nombre;                  // Nombre o descripción de la entidad
    private double valorBase;               // Valor unitario del ítem (puede ser costo, precio, tiempo estimado)

    // 🌿 Estructura recursiva: esta entidad puede contener otras entidades hijas
    private List<EntidadRecursivaBase> subEntidades = new ArrayList<>();

    public EntidadRecursivaBase(String id, String nombre, double valorBase) {
        this.id = id;
        this.nombre = nombre;
        this.valorBase = valorBase;
    }

    // ➕ Agrega una subentidad al conjunto de esta entidad
    public void agregarSubEntidad(EntidadRecursivaBase e) {
        subEntidades.add(e);
    }

    // 📜 Lista de subentidades actuales
    public List<EntidadRecursivaBase> getSubEntidades() {
        return subEntidades;
    }

    // 🧠 Cálculo recursivo del valor total considerando todos los subcomponentes
    public double calcularValorTotal() {
        double total = valorBase;
        for (EntidadRecursivaBase sub : subEntidades) {
            total += sub.calcularValorTotal(); // 🔁 llamada recursiva
        }
        return total;
    }

    // 🔎 Métodos de acceso
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public double getValorBase() { return valorBase; }
    public void setValorBase(double valorBase) { this.valorBase = valorBase; }
}

/*
🎯 ¿Cómo reutilizar esta clase? Casos de uso adaptables:

1. 🛒 Inventario:
   - Cada producto es una EntidadRecursivaBase.
   - Un kit puede tener múltiples componentes como subentidades.

2. 🏗️ Proyectos de construcción:
   - Un proyecto (casa) tiene partes (habitaciones), y estas partes tienen subpartes (puertas, ventanas).

3. 🩺 Sistema de atención médica:
   - Un tratamiento incluye estudios, procedimientos, medicamentos, todos como subcomponentes.

4. 🧾 Trámites administrativos:
   - Un trámite puede contener pasos intermedios (requisitos, validaciones, etc.)

5. 🍔 Menú de restaurante:
   - Un combo contiene platillos, bebidas, postres, cada uno como subentidad con valor.

Puedes extender esta clase con herencia para agregar más lógica (cálculo de impuestos, impresión, etc.).
*/
