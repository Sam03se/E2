import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioPrincipal extends JFrame {
    private JPanel mainPanel;               // Panel principal del formulario
    private JTextField txtID;               // Puede ser código de producto, cédula, matrícula, etc.
    private JTextField txtNombre;           // Puede ser nombre del cliente, estudiante, empleado
    private JTextField txtValorBase;        // Puede ser precio base, sueldo, matrícula, monto solicitado
    private JTextField txtMision;           // Puede ser carrera, departamento, categoría, descripción
    private JTextField txtPeligrosidad;     // Puede ser promedio, nivel de riesgo, urgencia, prioridad
    private JButton btnAgregar;             // Botón para guardar/registrar entidad
    private JTextArea areaResultado;        // Muestra el resumen del cálculo o confirmación

    private ControladorEntidad controlador = new ControladorEntidad(); // Controlador CRUD
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton agregarButton;
    private JTextArea textArea1;

    public FormularioPrincipal() {
        setContentPane(mainPanel);
        setTitle("Gestión de Agentes"); // Cambiar según el contexto: Gestión de Estudiantes, Inventario, etc.
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = txtID.getText();                      // Puede ser ID de estudiante o código
                    String nombre = txtNombre.getText();              // Nombre de persona u objeto
                    double valorBase = Double.parseDouble(txtValorBase.getText()); // Valor asociado
                    String mision = txtMision.getText();              // Rol, categoría, carrera
                    int peligrosidad = Integer.parseInt(txtPeligrosidad.getText()); // Nota, riesgo, nivel

                    Agente agente = new Agente(id, nombre, valorBase, mision, peligrosidad); // Puede llamarse Estudiante, Producto, etc.
                    controlador.agregarEntidad(agente);

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
        new FormularioPrincipal(); // Inicia la ventana al ejecutar
    }
}
