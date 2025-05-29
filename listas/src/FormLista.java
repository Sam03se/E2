// FormLista.java - Ventana Swing para gestionar listas de productos

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class FormLista extends JFrame {
    private JPanel panelPrincipal;
    private JComboBox<String> comboTipoLista;
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JTextField txtCantidad;
    private JButton btnAgregar;
    private JButton btnOrdenar;
    private JButton btnBuscar;
    private JTable tablaProductos;
    private JComboBox<String> comboCriterio;
    private JTextField txtBuscarId;

    private Lista listaActual;
    private DefaultTableModel modeloTabla;
    private JLabel IblBuscar;

    public FormLista() {
        setTitle("Gestión de Lista de Productos");
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);

        // Inicializa combo
        comboTipoLista.addItem("Simple");
        comboTipoLista.addItem("Doble");
        comboTipoLista.addItem("Circular Simple");
        comboTipoLista.addItem("Circular Doble");

        comboCriterio.addItem("ID");
        comboCriterio.addItem("Nombre");
        comboCriterio.addItem("Precio");
        comboCriterio.addItem("Cantidad");

        modeloTabla = new DefaultTableModel(new Object[]{"ID", "Nombre", "Precio", "Cantidad"}, 0);
        tablaProductos.setModel(modeloTabla);

        // Cambiar tipo de lista
        comboTipoLista.addActionListener(e -> seleccionarLista(comboTipoLista.getSelectedIndex()));
        seleccionarLista(0); // inicial

        // Agregar producto
        btnAgregar.addActionListener(e -> {
            int id = Integer.parseInt(txtId.getText());
            String nombre = txtNombre.getText();
            double precio = Double.parseDouble(txtPrecio.getText());
            int cantidad = Integer.parseInt(txtCantidad.getText());
            listaActual.insertar(new Producto(id, nombre, precio, cantidad));
            actualizarTabla();
        });

        // Ordenar lista
        btnOrdenar.addActionListener(e -> {
            List<Producto> productos = listaActual.obtenerLista();
            switch (comboCriterio.getSelectedIndex()) {
                case 0 -> productos.sort(Comparadores.porId);
                case 1 -> productos.sort(Comparadores.porNombre);
                case 2 -> productos.sort(Comparadores.porPrecio);
                case 3 -> productos.sort(Comparadores.porCantidad);
            }
            actualizarTabla();
        });

        // Buscar por ID
        btnBuscar.addActionListener(e -> {
            int idBuscar = Integer.parseInt(txtBuscarId.getText());
            for (Producto p : listaActual.obtenerLista()) {
                if (p.getId() == idBuscar) {
                    JOptionPane.showMessageDialog(this, "Encontrado: " + p);
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "No encontrado.");
        });
    }

    private void seleccionarLista(int tipo) {
        switch (tipo) {
            case 0 -> listaActual = new ListaSimple();
            case 1 -> listaActual = new ListaDoble();
            case 2 -> listaActual = new ListaCircularSimple();
            case 3 -> listaActual = new ListaCircularDoble();
        }
        actualizarTabla();
    }

    private void actualizarTabla() {
        modeloTabla.setRowCount(0);
        for (Producto p : listaActual.obtenerLista()) {
            modeloTabla.addRow(new Object[]{p.getId(), p.getNombre(), p.getPrecio(), p.getCantidad()});
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormLista().setVisible(true));
    }
}
// === FormLista.form ===
// Este es un esquema visual y nombres de componentes para armar el .form manualmente:

// [JPanel] panelPrincipal (contenedor raíz del formulario)
// ├── [JComboBox<String>] comboTipoLista      // Lista desplegable para seleccionar el tipo de lista
// │    → Opciones: "Simple", "Doble", "Circular Simple", "Circular Doble"
// ├── [JLabel] lblId                          // Texto: "ID"
// ├── [JTextField] txtId                      // Campo de texto para ingresar el ID
// ├── [JLabel] lblNombre                      // Texto: "Nombre"
// ├── [JTextField] txtNombre                  // Campo de texto para el nombre
// ├── [JLabel] lblPrecio                      // Texto: "Precio"
// ├── [JTextField] txtPrecio                  // Campo de texto para el precio
// ├── [JLabel] lblCantidad                    // Texto: "Cantidad"
// ├── [JTextField] txtCantidad                // Campo de texto para la cantidad
// ├── [JButton] btnAgregar                    // Texto: "Agregar"
// ├── [JButton] btnOrdenar                    // Texto: "Ordenar"
// ├── [JComboBox<String>] comboCriterio       // Criterios: "ID", "Nombre", "Precio", "Cantidad"
// ├── [JLabel] lblBuscar                      // Texto: "Buscar ID"
// ├── [JTextField] txtBuscarId                // Campo para ingresar el ID a buscar
// ├── [JButton] btnBuscar                     // Texto: "Buscar"
// └── [JTable] tablaProductos                 // Tabla para mostrar los productos agregados
