// Clase abstracta base para cualquier tipo de entidad gestionada
public abstract class EntidadBase {
    protected String id;              // Puede ser ID de estudiante, empleado, producto, etc.
    protected String nombre;          // Nombre de la persona o descripción del objeto
    protected double valorBase;       // Sueldo, precio base, matrícula, etc.

    public EntidadBase(String id, String nombre, double valorBase) {
        this.id = id;
        this.nombre = nombre;
        this.valorBase = valorBase;
    }

    // Ajuste 1: Puede representar descuento, penalización o factor variable
    public abstract double calcularAjuste1(); // Ej: valorBase * 0.5 (50% descuento)

    // Ajuste 2: Aporte a un fondo, comisión, interés mensual, etc.
    public abstract double calcularAjuste2(); // Ej: valorBase * 0.08 (aporte del 8%)

    // Ajuste 3: Impuestos o deducciones según tramos progresivos
    public abstract double calcularAjuste3(); // Ej: cálculo de impuesto anual

    // Ajuste 4: Bonificación, extra por rendimiento, cargo adicional
    public abstract double calcularAjuste4(); // Ej: bono por promedio alto o peligrosidad

    // Total final: Valor neto resultante (ej: sueldo neto, matrícula final, precio final)
    public abstract double calcularTotalFinal();

    // Getters y setters para herencia y acceso desde controladores
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public double getValorBase() { return valorBase; }
    public void setValorBase(double valorBase) { this.valorBase = valorBase; }
}