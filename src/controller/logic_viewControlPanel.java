package controller;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.user;
import model.userDAO;
import view.viewControlPanel;

public class logic_viewControlPanel implements ActionListener,parametrizable {
	private viewControlPanel vcp;
	private final String[] roll= {"Administrador","Vendedor","Cliente"};

	public logic_viewControlPanel(viewControlPanel vcp) {
		super();
		this.vcp = vcp;
		vcp.btn_RegisterAdd.addActionListener(this);
		loadElementsComboBox();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==vcp.btn_RegisterAdd) {
			if(validateFields()) {
				registerUser();
			}
		}
	}
	private void registerUser() {
		// TODO Auto-generated method stub
		userDAO udao=new userDAO(new user(
				vcp.txt_RegisterUser.getText(),
				formatText(vcp.txt_RegisterPSW.getPassword()),
				vcp.cmb_RegisterRoll.getSelectedIndex()+1
				));
		try {
			if(udao.writeFileUser()) {
				JOptionPane.showMessageDialog(vcp, "Registro exitoso","Registro de Usuarios",JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (HeadlessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	private boolean validateFields() {
		boolean flag=false;
		int contErrores=0;
		
		flag=validateEmail(vcp.txt_RegisterUser.getText());
		if(!flag) {
			vcp.txt_RegisterUser.setBackground(Color.RED);
			contErrores++;
		}else {
			vcp.txt_RegisterUser.setBackground(Color.GREEN);
		}
		
		flag=validatePSW(formatText(vcp.txt_RegisterPSW.getPassword()));
		if(!flag) {
			vcp.txt_RegisterPSW.setBackground(Color.RED);
			contErrores++;
		}else {
			vcp.txt_RegisterPSW.setBackground(Color.GREEN);
		}
		flag= formatText(vcp.txt_RegisterPSW.getPassword()).equals(formatText(vcp.txt_confirmarPSW.getPassword()));
		
		if(!flag) {
			vcp.txt_confirmarPSW.setBackground(Color.RED);
			contErrores++;
		}else {
			vcp.txt_confirmarPSW.setBackground(Color.GREEN);
		}
		
		if(contErrores==0) {
			return true;
		}else {
			return false;
		}
			
		/**
		 * cuando usamos enJTextField
		 * vcp.txt_RegisterPSW.getText().equals(vcp.txt_confirmarPSW.getText();
		 */
		
		
	}

	private void loadElementsComboBox() {
		for(String e:roll) {
			vcp.cmb_RegisterRoll.addItem(e);
		}
	}
}
