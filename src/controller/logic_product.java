package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel; // Importar DefaultTableModel
import model.product;
import model.productDAO;
import view.viewControlPanel;

public class logic_product implements ActionListener {
    private viewControlPanel vcp;
    private productDAO pdao;

    public logic_product(viewControlPanel vcp) {
        super();
        this.vcp = vcp;
        vcp.btn_productInsert.addActionListener(this);
        vcp.btn_productUpdate.addActionListener(this);
        vcp.btn_productDelete.addActionListener(this);
        vcp.btn_productConsult.addActionListener(this);

        // Cargar productos al inicio o al seleccionar la pestaña
        vcp.tabbedPane.addChangeListener(e -> {
            if (vcp.tabbedPane.getSelectedComponent() == vcp.getPn_product()) {
                loadProductsTable();
            }
        });
        loadProductsTable(); // Cargar al inicio por si la pestaña de productos es la inicial
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vcp.btn_productInsert) {
            insertProduct();
        } else if (e.getSource() == vcp.btn_productUpdate) {
            updateProduct();
        } else if (e.getSource() == vcp.btn_productDelete) {
            deleteProduct();
        } else if (e.getSource() == vcp.btn_productConsult) {
            consultProducts(); // Este método ahora llenará la JTable
        }
    }

    private void insertProduct() {
        try {
            String name = vcp.txt_productName.getText();
            String code = vcp.txt_productCode.getText();
            int stock = Integer.parseInt(vcp.txt_productStock.getText());
            double price = Double.parseDouble(vcp.txt_productPrice.getText());

            product p = new product(0, name, code, stock, price, new Date());
            pdao = new productDAO(p);

            if (pdao.addProduct()) {
                JOptionPane.showMessageDialog(vcp, "Producto insertado exitosamente.", "Gestión de Productos", JOptionPane.INFORMATION_MESSAGE);
                clearFields();
                loadProductsTable(); // Recargar la tabla después de insertar
            } else {
                JOptionPane.showMessageDialog(vcp, "Fallo al insertar producto.", "Gestión de Productos", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vcp, "Entrada inválida para Stock o Precio. Por favor, introduce valores numéricos.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vcp, "Ocurrió un error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void updateProduct() {
        try {
            String name = vcp.txt_productName.getText();
            String code = vcp.txt_productCode.getText();
            int stock = Integer.parseInt(vcp.txt_productStock.getText());
            double price = Double.parseDouble(vcp.txt_productPrice.getText());

            List<product> products = new productDAO().getAllProducts();
            product productToUpdate = null;
            for (product prod : products) {
                if (prod.getName_product().equalsIgnoreCase(name)) {
                    productToUpdate = prod;
                    break;
                }
            }

            if (productToUpdate != null) {
                int productId = productToUpdate.getId_product();
                product p = new product(productId, name, code, stock, price, productToUpdate.getCreate());
                pdao = new productDAO(p);
                if (pdao.updateProduct()) {
                    JOptionPane.showMessageDialog(vcp, "Producto actualizado exitosamente.", "Gestión de Productos", JOptionPane.INFORMATION_MESSAGE);
                    clearFields();
                    loadProductsTable(); // Recargar la tabla después de actualizar
                } else {
                    JOptionPane.showMessageDialog(vcp, "Fallo al actualizar producto.", "Gestión de Productos", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(vcp, "Producto no encontrado para actualizar. Asegúrate de que el nombre sea correcto.", "Gestión de Productos", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vcp, "Entrada inválida para Stock o Precio. Por favor, introduce valores numéricos.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vcp, "Ocurrió un error durante la actualización: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void deleteProduct() {
        try {
            String nameToDelete = vcp.txt_productName.getText();

            if (nameToDelete.isEmpty()) {
                JOptionPane.showMessageDialog(vcp, "Por favor, introduce el Nombre del Producto a eliminar.", "Entrada Requerida", JOptionPane.WARNING_MESSAGE);
                return;
            }

            List<product> products = new productDAO().getAllProducts();
            int productIdToDelete = -1;
            for (product prod : products) {
                if (prod.getName_product().equalsIgnoreCase(nameToDelete)) {
                    productIdToDelete = prod.getId_product();
                    break;
                }
            }

            if (productIdToDelete != -1) {
                product p = new product();
                p.setId_product(productIdToDelete);
                pdao = new productDAO(p);
                if (pdao.deleteProduct()) {
                    JOptionPane.showMessageDialog(vcp, "Producto eliminado exitosamente.", "Gestión de Productos", JOptionPane.INFORMATION_MESSAGE);
                    clearFields();
                    loadProductsTable(); // Recargar la tabla después de eliminar
                } else {
                    JOptionPane.showMessageDialog(vcp, "Fallo al eliminar producto.", "Gestión de Productos", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(vcp, "Producto no encontrado para eliminar. Asegúrate de que el nombre sea correcto.", "Gestión de Productos", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vcp, "Ocurrió un error durante la eliminación: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void consultProducts() {
        // El botón "Consultar" ahora llamará a loadProductsTable para mostrar los datos en la tabla
        loadProductsTable();
        JOptionPane.showMessageDialog(vcp, "Productos consultados y mostrados en la tabla.", "Consulta de Productos", JOptionPane.INFORMATION_MESSAGE);
    }

    public void loadProductsTable() {
        DefaultTableModel model = vcp.model_products;
        // Limpiar el modelo existente
        model.setRowCount(0);
        model.setColumnCount(0); // Limpiar columnas existentes

        // Definir los nombres de las columnas
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Código");
        model.addColumn("Stock");
        model.addColumn("Precio");
        model.addColumn("Creación");

        pdao = new productDAO();
        List<product> products = pdao.getAllProducts();

        if (products.isEmpty()) {
            // Opcional: Mostrar un mensaje si no hay productos
            // JOptionPane.showMessageDialog(vcp, "No se encontraron productos.", "Consulta de Productos", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        for (product p : products) {
            model.addRow(new Object[]{
                    p.getId_product(),
                    p.getName_product(),
                    p.getCod_product(),
                    p.getStock(),
                    p.getPrice(),
                    p.getCreate()
            });
        }
    }

    private void clearFields() {
        vcp.txt_productName.setText("");
        vcp.txt_productCode.setText("");
        vcp.txt_productStock.setText("");
        vcp.txt_productPrice.setText("");
    }
}