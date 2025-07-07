package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.employeed;
import model.employeedDAO;
import view.viewControlPanel;
import javax.swing.event.ChangeEvent; // ¡Añade esta línea!
import javax.swing.event.ChangeListener; // ¡Añade esta línea!

public class logic_employeed implements ActionListener {
    private viewControlPanel vcp;
    private employeedDAO edao;

    public logic_employeed(viewControlPanel vcp) {
        super();
        this.vcp = vcp;
        this.edao = new employeedDAO();

        // Puedes añadir un botón para "Cargar Empleados" o cargarlos automáticamente al seleccionar la pestaña
        // Por ahora, implementaremos la carga automática cuando la pestaña sea visible o al inicio.
        // Para una carga automática al inicio:
        loadEmployeedsTable();

        // Para cargar cuando se selecciona la pestaña (requiere un ChangeListener en JTabbedPane):
        vcp.tabbedPane.addChangeListener(new ChangeListener() { // Cambiado a clase anónima para mayor compatibilidad si usas una versión antigua de Java
            @Override
            public void stateChanged(ChangeEvent e) {
                if (vcp.tabbedPane.getSelectedComponent() == vcp.getPn_employeed()) {
                    loadEmployeedsTable();
                }
            }
        });
        // También puedes usar la expresión lambda si tu versión de Java lo permite (Java 8 o superior):
        // vcp.tabbedPane.addChangeListener(e -> {
        //     if (vcp.tabbedPane.getSelectedComponent() == vcp.pn_employeed) {
        //         loadEmployeedsTable();
        //     }
        // });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Aquí puedes añadir lógica para botones específicos de la pestaña de empleados si los creas
    }

    public void loadEmployeedsTable() {
        DefaultTableModel model = vcp.model_employeeds;
        // Limpiar el modelo existente
        model.setRowCount(0);
        model.setColumnCount(0); // Limpiar columnas existentes

        // Definir los nombres de las columnas
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("DNI");
        model.addColumn("Email");
        model.addColumn("Género");
        model.addColumn("Fecha Nac.");
        model.addColumn("Creación");
        model.addColumn("Salario");

        List<employeed> employeeds = edao.getAllEmployeeds();

        if (employeeds.isEmpty()) {
            // Opcional: Mostrar un mensaje si no hay empleados
            // JOptionPane.showMessageDialog(vcp, "No se encontraron empleados.", "Consulta de Empleados", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        for (employeed emp : employeeds) {
            model.addRow(new Object[]{
                    emp.getId_employeed(),
                    emp.getName_employeed(),
                    emp.getDni_employeed(),
                    emp.getEmail_employeed(),
                    emp.getGender(),
                    emp.getBirthdate(),
                    emp.getCreate(),
                    emp.getSalary()
            });
        }
    }
}