import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.stream.Collectors;

public class FormularioSort extends JFrame {
    private JPanel panelFormulario;
    private JTextField txtDatos;
    private JComboBox<String> comboAtributo;
    private JComboBox<String> comboMetodo;
    private JButton btnOrdenar;
    private JTextArea areaResultados;

    public FormularioSort() {
        setTitle("Ordenador de Objetos");
        setContentPane(panelFormulario);
        setSize(550, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        comboAtributo.addItem("Nombre");
        comboAtributo.addItem("ID");

        comboMetodo.addItem("Bubble Sort");
        comboMetodo.addItem("Insertion Sort");
        comboMetodo.addItem("Selection Sort");
        comboMetodo.addItem("Quick Sort");
        comboMetodo.addItem("Merge Sort");

        btnOrdenar.addActionListener((ActionEvent e) -> {
            try {
                List<Persona> lista = parsearEntrada(txtDatos.getText());

                Comparator<Persona> comparador = switch ((String) comboAtributo.getSelectedItem()) {
                    case "Nombre" -> ComparadoresPersona.porNombreAsc;
                    case "ID" -> ComparadoresPersona.porIdAsc;
                    default -> throw new IllegalArgumentException("Atributo no válido");
                };

                String metodo = (String) comboMetodo.getSelectedItem();
                switch (metodo) {
                    case "Bubble Sort" -> SortingAlgorithms.bubbleSort(lista, comparador);
                    case "Insertion Sort" -> SortingAlgorithms.insertionSort(lista, comparador);
                    case "Selection Sort" -> SortingAlgorithms.selectionSort(lista, comparador);
                    case "Quick Sort" -> SortingAlgorithms.quickSort(lista, comparador);
                    case "Merge Sort" -> SortingAlgorithms.mergeSort(lista, comparador);
                }

                areaResultados.setText("✅ Lista ordenada:\n");
                for (Persona p : lista) {
                    areaResultados.append("• " + p + "\n");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "❌ Error en los datos: " + ex.getMessage());
            }
        });
    }

    private List<Persona> parsearEntrada(String entrada) throws Exception {
        List<Persona> lista = new ArrayList<>();
        for (String parte : entrada.split(",")) {
            String[] partes = parte.trim().split(":");
            if (partes.length != 2) throw new Exception("Formato inválido");
            lista.add(new Persona(partes[0].trim(), Integer.parseInt(partes[1].trim())));
        }
        return lista;
    }
}
/*
✅ Nombre del archivo: FormularioSort.form
✅ Nombre del panel raíz (JPanel): panelFormulario

🛠 Componentes necesarios:

1. JTextField   -> txtDatos
   - Texto de ayuda (label): "Datos: (Formato → Nombre:ID,Nombre:ID)"

2. JComboBox    -> comboAtributo
   - Ítems: "Nombre", "ID"

3. JComboBox    -> comboMetodo
   - Ítems: "Bubble Sort", "Insertion Sort", etc.

4. JButton      -> btnOrdenar
   - Texto: "Ordenar"

5. JTextArea    -> areaResultados
   - NO editable (editable = false)
   - Preferiblemente dentro de un JScrollPane

📐 Distribución recomendada (vertical):

| Datos: [__________________________]              |
| Atributo: [combo ▼]    Método: [combo ▼]         |
| [Ordenar]                                        |
| Resultados:                                      |
| [JTextArea grande con scroll vertical]          |

✅ Todos los nombres en el .form deben coincidir con los definidos en el código.

ingreso de datos Luis:5, Marlon:4,...
*/
