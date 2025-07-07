package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.employeed;
import model.employeedDAO;
import view.viewControlPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class logic_employeed implements ActionListener {
    private viewControlPanel vcp;
    private employeedDAO edao;

    public logic_employeed(viewControlPanel vcp) {
        super();
        this.vcp = vcp;
        this.edao = new employeedDAO();

        loadEmployeedsTable();

        vcp.tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (vcp.tabbedPane.getSelectedComponent() == vcp.getPn_employeed()) {
                    loadEmployeedsTable();
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public void loadEmployeedsTable() {
        DefaultTableModel model = vcp.model_employeeds;
        model.setRowCount(0);
        model.setColumnCount(0);

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