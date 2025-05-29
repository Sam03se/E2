import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioEntidadRecursiva extends JFrame {
    private JPanel mainPanel;               // Panel principal (binding en .form)
    private JTextField txtID;              // ID único de la entidad raíz
    private JTextField txtNombre;          // Nombre o descripción
    private JTextField txtValorBase;       // Valor base individual
    private JTextField txtSubID;           // ID de la subentidad a agregar (opcional)
    private JTextField txtSubValor;        // Valor base de la subentidad
    private JButton btnAgregarEntidad;     // Botón para agregar entidad raíz
    private JButton btnAgregarSubEntidad;  // Botón para añadir subentidad a raíz existente
    private JTextArea areaResultado;       // Muestra el valor total recursivo

    private ControladorEntidadRecursiva controlador = new ControladorEntidadRecursiva();

    public FormularioEntidadRecursiva() {
        setContentPane(mainPanel);
        setTitle("Gestión de Entidades Recursivas");
        setSize(600, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        btnAgregarEntidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = txtID.getText();
                    String nombre = txtNombre.getText();
                    double valor = Double.parseDouble(txtValorBase.getText());

                    EntidadRecursivaBase nueva = new EntidadRecursivaBase(id, nombre, valor);
                    controlador.agregarEntidad(nueva);
                    areaResultado.setText("Entidad agregada con éxito: " + nombre);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al agregar entidad: " + ex.getMessage());
                }
            }
        });

        btnAgregarSubEntidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String idRaiz = txtID.getText();
                    String subId = txtSubID.getText();
                    double subValor = Double.parseDouble(txtSubValor.getText());

                    EntidadRecursivaBase sub = new EntidadRecursivaBase(subId, "Sub de " + idRaiz, subValor);
                    EntidadRecursivaBase padre = controlador.buscarPorId(idRaiz);

                    if (padre != null) {
                        padre.agregarSubEntidad(sub);
                        double total = padre.calcularValorTotal();
                        areaResultado.setText("Subentidad agregada a " + idRaiz +
                                "\nValor total actualizado: $" + String.format("%.2f", total));
                    } else {
                        areaResultado.setText("No se encontró entidad raíz con ID: " + idRaiz);
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al agregar subentidad: " + ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        new FormularioEntidadRecursiva();
    }
}
/*
============================================================================
🎨 DISEÑO VISUAL DEL FORMULARIO - FormularioEntidadRecursiva.form (Swing UI Designer)
============================================================================

📌 Este formulario permite crear entidades principales (ej. combos, trámites, productos)
    y agregarles subentidades de forma recursiva.

✔️ Disposición sugerida: GridLayout con 9 filas y 2 columnas (o GridBag para más control)

| FILA | COMPONENTE IZQUIERDA         | COMPONENTE DERECHA / ACCIÓN         | BINDING NAME            | DESCRIPCIÓN                                         |
|------|-------------------------------|--------------------------------------|--------------------------|-----------------------------------------------------|
| 1    | JLabel: "ID Raíz"             | JTextField                           | txtID                   | ID de la entidad raíz (ej. COMBO001, TRAMITE01)     |
| 2    | JLabel: "Nombre"              | JTextField                           | txtNombre               | Nombre o descripción de la entidad raíz             |
| 3    | JLabel: "Valor Base"          | JTextField                           | txtValorBase            | Valor unitario inicial                              |
| 4    |                              —| JButton: "Agregar Entidad"           | btnAgregarEntidad       | Crea la entidad raíz y la guarda en el sistema      |
| 5    | JLabel: "Sub-ID"              | JTextField                           | txtSubID                | ID para la subentidad a asociar                     |
| 6    | JLabel: "Sub-Valor Base"      | JTextField                           | txtSubValor             | Valor base de la subentidad                         |
| 7    |                              —| JButton: "Agregar Subentidad"        | btnAgregarSubEntidad    | Asocia subentidad al ID raíz especificado arriba    |
| 8    | JLabel: "Resultado / Total"   | JTextArea                            | areaResultado           | Muestra resultados del sistema y valor total        |

🧩 COMPONENTES CLAVE:
- mainPanel              → JPanel contenedor principal (binding obligatorio)
- Todos los componentes deben tener sus binding names iguales al .java

============================================================================
🔁 ¿Qué representa cada componente?
============================================================================
- txtID            → ID de la entidad principal (puede representar combo, trámite, módulo)
- txtNombre        → Descripción corta para mostrar o guardar
- txtValorBase     → Valor directo o costo inicial
- txtSubID         → Código de subentidad a añadir
- txtSubValor      → Costo asociado a esa subentidad
- areaResultado    → Mensaje o total acumulado, útil para validar recursividad

============================================================================
🎯 Adaptaciones posibles:
============================================================================
- Cambia “Subentidad” por “Parte del producto”, “Paso del trámite”, “Subtarea”, etc.
- Cambia “Valor base” por tiempo estimado, costo, duración o unidades
============================================================================
*/
