// Clase concreta: Agente de seguridad (puede cambiarse a Empleado, Estudiante, etc.)
public class Agente extends EntidadBase {
    private String mision;           // En otro caso puede ser "carrera" o "producto asignado"
    private int peligrosidad;       // En otro caso puede ser "promedio académico", "riesgo financiero"

    public Agente(String id, String nombre, double valorBase, String mision, int peligrosidad) {
        super(id, nombre, valorBase);
        this.mision = mision;
        this.peligrosidad = peligrosidad;
    }

    @Override
    public double calcularAjuste1() {
        return valorBase * 0.5; // Ejemplo: descuento del 50% por beca, rebaja o penalización
    }

    @Override
    public double calcularAjuste2() {
        return valorBase * 0.08; // Ejemplo: aporte al fondo común o comisión del 8%
    }

    @Override
    public double calcularAjuste3() {
        // Ejemplo: cálculo de impuesto progresivo (adaptable a otras deducciones)
        double anual = valorBase * 12;
        if (anual <= 5000) return 0;
        else if (anual <= 10000) return (anual - 5000) * 0.10;
        else if (anual <= 20000) return 500 + (anual - 10000) * 0.20;
        else return 2500 + (anual - 20000) * 0.30;
    }

    @Override
    public double calcularAjuste4() {
        return peligrosidad >= 4 ? valorBase * 0.1 : 0; // Ej: bono por peligrosidad alta o rendimiento
    }

    @Override
    public double calcularTotalFinal() {
        // Fórmula neta final (puede cambiarse en otros contextos)
        return valorBase - calcularAjuste2() - (calcularAjuste3() / 12) + calcularAjuste4();
    }
}
