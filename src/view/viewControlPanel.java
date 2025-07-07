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

import controller.logic_viewControlPanel;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class viewControlPanel extends JFrame{
	//se vuelve publico cuando se necesita gestionar cada uno de ellos
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
	
	public viewControlPanel() {
		setTitle("Panel de Control");
		setBounds(100,100,425,300);
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
		gbl_pn_registerUser.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		txt_RegisterPSW.setToolTipText("Iniciar con numeros o letras c minimo 8 caracteresres y finainalizar con un caracter especial: _*");
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
//		tabbedPane.addTab("Productos", null, pn_product, null);
		
		pn_employeed = new JPanel();
		pn_employeed.setBackground(new Color(128, 255, 128));
//		tabbedPane.addTab("Empleados", null, pn_employeed, null);
		
		pn_client = new JPanel();
		pn_client.setBackground(new Color(128, 128, 255));
//		tabbedPane.addTab("Clientes", null, pn_client, null);
		
		pn_factura = new JPanel();
		pn_factura.setBackground(new Color(255, 128, 128));
//		tabbedPane.addTab("Factura", null, pn_factura, null);
		
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
	
	
}
