import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioPrincipal extends JFrame {
    // 🎯 Estos son los componentes que se deben vincular en el archivo .form (bindings)
    private JPanel mainPanel;               // Panel raíz del formulario, debe llamarse "mainPanel"
    private JTextField txtID;               // Ej: código del producto, ID del estudiante, cédula del cliente
    private JTextField txtNombre;           // Ej: nombre del agente, nombre del estudiante, descripción del producto
    private JTextField txtValorBase;        // Ej: pago mensual, precio base, matrícula, sueldo base
    private JTextField txtMision;           // Ej: misión, categoría, carrera, departamento
    private JTextField txtPeligrosidad;     // Ej: nivel de riesgo, promedio, nivel académico
    private JButton btnAgregar;             // Botón para registrar/agregar entidad
    private JTextArea areaResultado;        // Área de texto para mostrar resultado o resumen

    private ControladorEntidad controlador = new ControladorEntidad(); // CRUD general para EntidadBase

    public FormularioPrincipal() {
        // 🚀 Configuración inicial de la ventana
        setContentPane(mainPanel);               // Este panel debe existir en el .form con el nombre "mainPanel"
        setTitle("Gestión de Agentes");          // Puedes cambiar a "Gestión de Estudiantes", "Inventario", etc.
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        // ✅ Acción del botón para agregar un nuevo objeto
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // 💡 Recolección de datos desde los campos
                    String id = txtID.getText();
                    String nombre = txtNombre.getText();
                    double valorBase = Double.parseDouble(txtValorBase.getText());
                    String mision = txtMision.getText();
                    int peligrosidad = Integer.parseInt(txtPeligrosidad.getText());

                    // 🧠 Creación del objeto Agente (puede adaptarse a Estudiante, Producto, etc.)
                    Agente agente = new Agente(id, nombre, valorBase, mision, peligrosidad);

                    // 📥 Agregar al controlador (lista de entidades)
                    controlador.agregarEntidad(agente);

                    // 📤 Mostrar resumen en pantalla
                    areaResultado.setText("Entidad agregada:\n" +
                            "ID: " + id + "\n" +
                            "Nombre: " + nombre + "\n" +
                            "Valor Neto: $" + String.format("%.2f", agente.calcularTotalFinal()));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al ingresar datos: " + ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        // 🟢 Ejecutar la ventana principal
        new FormularioPrincipal();
    }
}

/*
============================================================================
🎨 ESTRUCTURA DEL FORMULARIO - FormularioPrincipal.form (Diseñado en IntelliJ)
============================================================================

📌 Este diseño está basado en un GridLayout de 7 filas y 2 columnas.

| FILA | COLUMNA IZQ (JLabel) | COLUMNA DER (Campo/Input)         | BINDING NAME        | DESCRIPCIÓN                                            |
|------|-----------------------|-----------------------------------|----------------------|--------------------------------------------------------|
| 1    | "ID:"                | JTextField                        | txtID               | Identificador (ID del agente, producto, estudiante...)|
| 2    | "Nombre:"            | JTextField                        | txtNombre           | Nombre de la entidad                                  |
| 3    | "Valor Base:"        | JTextField                        | txtValorBase        | Sueldo, precio base, matrícula, etc.                  |
| 4    | "Misión:"            | JTextField                        | txtMision           | Puede ser misión, carrera, categoría, etc.            |
| 5    | "Peligrosidad:"      | JTextField                        | txtPeligrosidad     | Nivel de riesgo, promedio, nivel académico, etc.      |
| 6    |                     —| JButton ("Agregar Agente")        | btnAgregar          | Botón para registrar o guardar la entidad             |
| 7    |                     —| JTextArea                         | areaResultado       | Muestra resultado del cálculo o mensaje de confirmación|

🧩 PANEL RAÍZ:
- Tipo: JPanel
- Binding Name: mainPanel

🧩 BOTÓN:
- Texto visible: "Agregar Agente"
- Binding Name: btnAgregar

🧩 ÁREA DE TEXTO:
- Binding Name: areaResultado
- Propiedad: `lineWrap = true`, opcionalmente `rows = 4`

============================================================================
✅ ADAPTACIONES POSIBLES
============================================================================

🔄 Si adaptas este sistema a:
- Estudiantes: cambia "Misión" por "Carrera", "Peligrosidad" por "Promedio"
- Productos: cambia "Nombre" por "Descripción", "Misión" por "Categoría"
- Empleados: cambia "Peligrosidad" por "Antigüedad", etc.

============================================================================
*/


