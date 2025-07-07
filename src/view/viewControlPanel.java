package view;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.logic_viewControlPanel;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class viewControlPanel extends JFrame{
	private JPanel pn_employeed;
	private JPanel pn_client;
	private JPanel pn_factura;
	private JPanel pn_product;
	private JPanel pn_registerUser;

	public JTabbedPane tabbedPane;
	public JTextField txt_RegisterUser;
	public JPasswordField txt_RegisterPSW;
	public JButton btn_RegisterAdd;
	public JComboBox cmb_RegisterRoll;
	public JPasswordField txt_confirmarPSW;
	private JSeparator separator;

	// For Product Panel
	public JTextField txt_productName;
	public JTextField txt_productCode;
	public JTextField txt_productStock;
	public JTextField txt_productPrice;
	public JButton btn_productInsert;
	public JButton btn_productUpdate;
	public JButton btn_productDelete;
	public JButton btn_productConsult;
	public DefaultTableModel model_products;
	public JTable tbl_products;

	// For Employeed Panel
	public DefaultTableModel model_employeeds;
	public JTable tbl_employeeds;

	public viewControlPanel() {
		setTitle("Panel de Control");
		setBounds(100,100,600,400);
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				viewLogin vl=new viewLogin();
				vl.setVisible(true);
				vl.setLocationRelativeTo(null);
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane);

		pn_registerUser = new JPanel();
		pn_registerUser.setBackground(new Color(128, 128, 128));
//		tabbedPane.addTab("Registrar", null, pn_registerUser, null);
		GridBagLayout gbl_pn_registerUser = new GridBagLayout();
		gbl_pn_registerUser.columnWidths = new int[]{0, 0, 0, 0};
		gbl_pn_registerUser.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pn_registerUser.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pn_registerUser.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pn_registerUser.setLayout(gbl_pn_registerUser);

		separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 1;
		gbc_separator.gridy = 0;
		pn_registerUser.add(separator, gbc_separator);

		JLabel lblNewLabel = new JLabel("User: ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		pn_registerUser.add(lblNewLabel, gbc_lblNewLabel);

		txt_RegisterUser = new JTextField();
		txt_RegisterUser.setToolTipText("Ingresar un correo electronico");
		txt_RegisterUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_txt_RegisterUser = new GridBagConstraints();
		gbc_txt_RegisterUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_RegisterUser.insets = new Insets(0, 0, 5, 0);
		gbc_txt_RegisterUser.gridx = 2;
		gbc_txt_RegisterUser.gridy = 1;
		pn_registerUser.add(txt_RegisterUser, gbc_txt_RegisterUser);
		txt_RegisterUser.setColumns(10);

		JLabel lblContrasea = new JLabel("Password: ");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.anchor = GridBagConstraints.WEST;
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 1;
		gbc_lblContrasea.gridy = 2;
		pn_registerUser.add(lblContrasea, gbc_lblContrasea);

		txt_RegisterPSW = new JPasswordField();
		txt_RegisterPSW.setToolTipText("Iniciar con numeros o letras c minimo 8 caracteresres y finainalizar con un caracter especial: _* ");
		txt_RegisterPSW.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_RegisterPSW.setEchoChar('*');
		GridBagConstraints gbc_txt_RegisterPSW = new GridBagConstraints();
		gbc_txt_RegisterPSW.insets = new Insets(0, 0, 5, 0);
		gbc_txt_RegisterPSW.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_RegisterPSW.gridx = 2;
		gbc_txt_RegisterPSW.gridy = 2;
		pn_registerUser.add(txt_RegisterPSW, gbc_txt_RegisterPSW);

		JLabel lblConfirmar = new JLabel("Confirmar: ");
		lblConfirmar.setForeground(Color.WHITE);
		lblConfirmar.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblConfirmar = new GridBagConstraints();
		gbc_lblConfirmar.anchor = GridBagConstraints.EAST;
		gbc_lblConfirmar.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfirmar.gridx = 1;
		gbc_lblConfirmar.gridy = 3;
		pn_registerUser.add(lblConfirmar, gbc_lblConfirmar);

		txt_confirmarPSW = new JPasswordField();
		txt_confirmarPSW.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_confirmarPSW.setEchoChar('*');
		GridBagConstraints gbc_txt_confirmarPSW = new GridBagConstraints();
		gbc_txt_confirmarPSW.insets = new Insets(0, 0, 5, 0);
		gbc_txt_confirmarPSW.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_confirmarPSW.gridx = 2;
		gbc_txt_confirmarPSW.gridy = 3;
		pn_registerUser.add(txt_confirmarPSW, gbc_txt_confirmarPSW);

		JLabel lblRoll = new JLabel("Roll:");
		lblRoll.setForeground(Color.WHITE);
		lblRoll.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblRoll = new GridBagConstraints();
		gbc_lblRoll.insets = new Insets(0, 0, 5, 5);
		gbc_lblRoll.anchor = GridBagConstraints.WEST;
		gbc_lblRoll.gridx = 1;
		gbc_lblRoll.gridy = 4;
		pn_registerUser.add(lblRoll, gbc_lblRoll);

		cmb_RegisterRoll = new JComboBox();
		cmb_RegisterRoll.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_cmb_RegisterRoll = new GridBagConstraints();
		gbc_cmb_RegisterRoll.insets = new Insets(0, 0, 5, 0);
		gbc_cmb_RegisterRoll.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmb_RegisterRoll.gridx = 2;
		gbc_cmb_RegisterRoll.gridy = 4;
		pn_registerUser.add(cmb_RegisterRoll, gbc_cmb_RegisterRoll);

		btn_RegisterAdd = new JButton("Add");
		btn_RegisterAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_btn_RegisterAdd = new GridBagConstraints();
		gbc_btn_RegisterAdd.anchor = GridBagConstraints.EAST;
		gbc_btn_RegisterAdd.insets = new Insets(0, 0, 5, 0);
		gbc_btn_RegisterAdd.gridx = 2;
		gbc_btn_RegisterAdd.gridy = 5;
		pn_registerUser.add(btn_RegisterAdd, gbc_btn_RegisterAdd);

		pn_product = new JPanel();
		pn_product.setBackground(new Color(255, 128, 255));
		// Add product components
		pn_product.setLayout(new GridBagLayout());
		GridBagConstraints gbc_product = new GridBagConstraints();
		gbc_product.insets = new Insets(5, 5, 5, 5);
		gbc_product.fill = GridBagConstraints.HORIZONTAL;

		JLabel lblProductName = new JLabel("Name:");
		gbc_product.gridx = 0; gbc_product.gridy = 0;
		pn_product.add(lblProductName, gbc_product);
		txt_productName = new JTextField(15);
		gbc_product.gridx = 1; gbc_product.gridy = 0;
		pn_product.add(txt_productName, gbc_product);

		JLabel lblProductCode = new JLabel("Code:");
		gbc_product.gridx = 0; gbc_product.gridy = 1;
		pn_product.add(lblProductCode, gbc_product);
		txt_productCode = new JTextField(15);
		gbc_product.gridx = 1; gbc_product.gridy = 1;
		pn_product.add(txt_productCode, gbc_product);

		JLabel lblProductStock = new JLabel("Stock:");
		gbc_product.gridx = 0; gbc_product.gridy = 2;
		pn_product.add(lblProductStock, gbc_product);
		txt_productStock = new JTextField(15);
		gbc_product.gridx = 1; gbc_product.gridy = 2;
		pn_product.add(txt_productStock, gbc_product);

		JLabel lblProductPrice = new JLabel("Price:");
		gbc_product.gridx = 0; gbc_product.gridy = 3;
		pn_product.add(lblProductPrice, gbc_product);
		txt_productPrice = new JTextField(15);
		gbc_product.gridx = 1; gbc_product.gridy = 3;
		pn_product.add(txt_productPrice, gbc_product);

		btn_productInsert = new JButton("Insert");
		gbc_product.gridx = 0; gbc_product.gridy = 4;
		pn_product.add(btn_productInsert, gbc_product);

		btn_productUpdate = new JButton("Update");
		gbc_product.gridx = 1; gbc_product.gridy = 4;
		pn_product.add(btn_productUpdate, gbc_product);

		btn_productDelete = new JButton("Delete");
		gbc_product.gridx = 0; gbc_product.gridy = 5;
		pn_product.add(btn_productDelete, gbc_product);

		btn_productConsult = new JButton("Consult");
		gbc_product.gridx = 1; gbc_product.gridy = 5;
		pn_product.add(btn_productConsult, gbc_product);

		model_products = new DefaultTableModel();
		tbl_products = new JTable(model_products);
		JScrollPane scrollPaneProducts = new JScrollPane(tbl_products);
		gbc_product.gridx = 0; gbc_product.gridy = 6;
		gbc_product.gridwidth = 2; gbc_product.weighty = 1.0; gbc_product.fill = GridBagConstraints.BOTH;
		pn_product.add(scrollPaneProducts, gbc_product);

		pn_employeed = new JPanel();
		pn_employeed.setBackground(new Color(128, 255, 128));
		pn_employeed.setLayout(new GridLayout(1, 0, 0, 0));
		model_employeeds = new DefaultTableModel();
		tbl_employeeds = new JTable(model_employeeds);
		JScrollPane scrollPaneEmployeeds = new JScrollPane(tbl_employeeds);
		pn_employeed.add(scrollPaneEmployeeds);

		pn_client = new JPanel();
		pn_client.setBackground(new Color(128, 128, 255));

		pn_factura = new JPanel();
		pn_factura.setBackground(new Color(255, 128, 128));

		new logic_viewControlPanel(this);
	}
	public void rollAdministrador() {
		tabbedPane.addTab("Productos", null, pn_product, null);
		tabbedPane.addTab("Empleados", null, pn_employeed, null);
		tabbedPane.addTab("Clientes", null, pn_client, null);
		tabbedPane.addTab("Factura", null, pn_factura, null);
		tabbedPane.addTab("Registrar", null, pn_registerUser, null);

	}
	public void rollVendedor() {
		tabbedPane.addTab("Clientes", null, pn_client, null);
		tabbedPane.addTab("Factura", null, pn_factura, null);
	}

	// Public getters for panels
	public JPanel getPn_employeed() {
		return pn_employeed;
	}

	public JPanel getPn_client() {
		return pn_client;
	}

	public JPanel getPn_factura() {
		return pn_factura;
	}

	public JPanel getPn_product() {
		return pn_product;
	}

	public JPanel getPn_registerUser() {
		return pn_registerUser;
	}
}