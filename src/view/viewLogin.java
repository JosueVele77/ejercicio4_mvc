package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.logic_viewLogin;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class viewLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txt_user;
	public JPasswordField txt_psw;
	public JButton btn_ok;
	public JButton btn_cancel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewLogin frame = new viewLogin();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public viewLogin() {
		setFont(new Font("Times New Roman", Font.PLAIN, 12));
		setTitle("Login");
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 408, 149);
		setResizable(false);//With this method is impossible change the size window
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 128, 0));
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("User: ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		txt_user = new JTextField();
		txt_user.setToolTipText("INGRESE EL USUARIO");
		txt_user.setBackground(new Color(255, 255, 255));
		txt_user.setForeground(new Color(0, 0, 0));
		txt_user.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_txt_user = new GridBagConstraints();
		gbc_txt_user.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_user.insets = new Insets(0, 0, 5, 0);
		gbc_txt_user.gridx = 2;
		gbc_txt_user.gridy = 0;
		contentPane.add(txt_user, gbc_txt_user);
		txt_user.setColumns(10);
		
		JLabel lblPasword = new JLabel("Pasword: ");
		lblPasword.setForeground(new Color(255, 255, 255));
		lblPasword.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_lblPasword = new GridBagConstraints();
		gbc_lblPasword.anchor = GridBagConstraints.EAST;
		gbc_lblPasword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPasword.gridx = 1;
		gbc_lblPasword.gridy = 1;
		contentPane.add(lblPasword, gbc_lblPasword);
		
		txt_psw = new JPasswordField();
		txt_psw.setEchoChar('*');
		txt_psw.setToolTipText("INGRESE LA CONTRASEÑA");
		txt_psw.setForeground(new Color(0, 0, 0));
		txt_psw.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txt_psw.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_txt_psw = new GridBagConstraints();
		gbc_txt_psw.insets = new Insets(0, 0, 5, 0);
		gbc_txt_psw.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_psw.gridx = 2;
		gbc_txt_psw.gridy = 1;
		contentPane.add(txt_psw, gbc_txt_psw);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(64, 128, 128));
		panel.setBackground(new Color(64, 128, 128));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 2;
		contentPane.add(panel, gbc_panel);
		
		btn_ok = new JButton("OK");
		btn_ok.setForeground(new Color(0, 0, 0));
		btn_ok.setToolTipText("ACEPTAR");
		btn_ok.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel.add(btn_ok);
		btn_ok.setBackground(Color.WHITE);
		
		btn_cancel = new JButton("CANCEL");
		btn_cancel.setForeground(Color.RED);
		btn_cancel.setBackground(Color.WHITE);
		btn_cancel.setToolTipText("CANCELAR");
		btn_cancel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel.add(btn_cancel);
		new logic_viewLogin(this);
	}

}
