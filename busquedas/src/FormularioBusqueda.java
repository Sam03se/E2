import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormularioBusqueda extends JFrame {
    private JPanel contentPane;
    private JTextField txtNombre;
    private JTextField txtCodigo;
    private JTextField txtPrecio;
    private JComboBox<String> comboEstrategiaBusqueda;
    private JButton btnAgregar;
    private JButton btnBuscar;
    private JButton btnOrdenar;
    private JTextArea areaResultados;

    private final ArrayList<Producto> listaProductos = new ArrayList<>();

    public FormularioBusqueda() {
        setTitle("Sistema de Búsqueda de Productos");
        setContentPane(contentPane);
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Rellenar estrategias
        comboEstrategiaBusqueda.addItem("Lineal");
        comboEstrategiaBusqueda.addItem("Binaria");
        comboEstrategiaBusqueda.addItem("Interpolada");
        comboEstrategiaBusqueda.addItem("Por Nombre");

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = txtNombre.getText();
                    int codigo = Integer.parseInt(txtCodigo.getText());
                    double precio = Double.parseDouble(txtPrecio.getText());
                    Producto p = new Producto(nombre, codigo, precio);
                    listaProductos.add(p);
                    areaResultados.append("✅ Producto agregado: " + p + "\n");
                    areaResultados.append("➡️ Puedes buscar este producto por nombre (\"" + nombre + "\") o código (" + codigo + ") según la estrategia seleccionada.\n\n");
                    limpiarCampos();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "❌ Error en los datos: " + ex.getMessage());
                }
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listaProductos.isEmpty()) {
                    areaResultados.append("⚠️ No hay productos registrados. Agrega alguno primero.\n\n");
                    return;
                }

                String opcion = (String) comboEstrategiaBusqueda.getSelectedItem();
                String entrada = JOptionPane.showInputDialog("🔍 Ingrese el valor a buscar (nombre o código según el método):");

                Producto[] array = listaProductos.toArray(new Producto[0]);
                int pos = -1;

                switch (opcion) {
                    case "Lineal" -> {
                        BusquedaLinealGenerica<Producto> busqueda = new BusquedaLinealGenerica<>();
                        Producto objetivo = parseObjetivo(entrada);
                        pos = busqueda.buscar(array, objetivo);
                        areaResultados.append("📊 Usando búsqueda LINEAL...\n");
                    }
                    case "Binaria" -> {
                        listaProductos.sort(Producto::compareTo);
                        BusquedaBinariaGenerica<Producto> busqueda = new BusquedaBinariaGenerica<>();
                        Producto objetivo = new Producto("", Integer.parseInt(entrada), 0);
                        pos = busqueda.buscar(array, objetivo);
                        areaResultados.append("🎯 Usando búsqueda BINARIA (por código, ordenado)...\n");
                    }
                    case "Interpolada" -> {
                        listaProductos.sort(Producto::compareTo);
                        BusquedaInterpoladaProducto busqueda = new BusquedaInterpoladaProducto();
                        Producto objetivo = new Producto("", Integer.parseInt(entrada), 0);
                        pos = busqueda.buscar(array, objetivo);
                        areaResultados.append("📈 Usando búsqueda INTERPOLADA (por código estimado)...\n");
                    }
                    case "Por Nombre" -> {
                        areaResultados.append("🔤 Usando búsqueda por NOMBRE...\n");
                        for (int i = 0; i < array.length; i++) {
                            if (array[i].getNombre().equalsIgnoreCase(entrada)) {
                                pos = i;
                                break;
                            }
                        }
                    }
                }

                if (pos >= 0) {
                    areaResultados.append("✅ Resultado: " + array[pos] + "\n\n");
                } else {
                    areaResultados.append("❌ No se encontró ningún producto con ese dato.\n\n");
                }
            }
        });

        btnOrdenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listaProductos.isEmpty()) {
                    areaResultados.append("⚠️ No hay productos para ordenar.\n\n");
                    return;
                }

                listaProductos.sort(Producto::compareTo);
                areaResultados.append("📑 Lista ordenada por código (ascendente):\n");
                for (Producto p : listaProductos) {
                    areaResultados.append("• " + p + "\n");
                }
                areaResultados.append("\n");
            }
        });
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtCodigo.setText("");
        txtPrecio.setText("");
    }

    private Producto parseObjetivo(String entrada) {
        try {
            int codigo = Integer.parseInt(entrada);
            return new Producto("", codigo, 0);
        } catch (NumberFormatException e) {
            return new Producto(entrada, 0, 0);
        }
    }
}


/*
🧩 Cómo debe verse el .form en Swing UI Designer (comentado):

✅ JPanel root:
- Nombre: contentPane

✅ Componentes:
- JTextField  -> txtNombre
- JTextField  -> txtCodigo
- JTextField  -> txtPrecio
- JComboBox   -> comboEstrategiaBusqueda
- JButton     -> btnAgregar
- JButton     -> btnBuscar
- JTextArea   -> areaResultados (de preferencia dentro de JScrollPane)

Distribúyelos de forma vertical o en una cuadrícula. Por ejemplo:

| Nombre: [___________]               |
| Código: [___________]              |
| Precio: [___________]              |
| Estrategia: [combo ▼]              |
| [Agregar] [Buscar]                 |
| Resultados: [AreaResultados grande]|

*/
