package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.user;
import model.userDAO;
import model.userDAO2;
import view.viewControlPanel;
import view.viewLogin;

public class logic_viewLogin implements ActionListener, parametrizable{
	private viewLogin vl;
	private userDAO2 udao;
	private viewControlPanel vcp;
	
	public logic_viewLogin(viewLogin vl) {
		super();
		this.vl = vl;
		this.udao=new userDAO2();
		this.vcp=new viewControlPanel();
		vl.btn_ok.addActionListener(this);
		vl.btn_cancel.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==vl.btn_ok) {
			if(validateField()) {
			}else {
				JOptionPane.showMessageDialog(vl, "\tCredenciales incorrectas","Login",JOptionPane.WARNING_MESSAGE);
			}
		}else if(e.getSource()==vl.btn_cancel) {
			JOptionPane.showMessageDialog(vl, "\tCierre de la Aplicación","Login",JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);//close the application 
		}
	}

	private boolean validateField() {
		String user= vl.txt_user.getText();
		String psw= formatText(vl.txt_psw.getPassword());
		List <user> users=new ArrayList<>() ;
//		try {
			users= udao.getUser();

//		}
		for(user u:users) {
			if(user.equals(u.getUser())&& psw.equals(u.getPsw())) {
				viewControlPanel vcp= new viewControlPanel();
				switch(u.getType()) {
				case 1:

					vcp.rollAdministrador();
					
					break;
				case 2:
					vcp.rollVendedor();
					
					break;
				default:
					System.out.println("Usuario sin privilegios");
					break;
				}
				vcp.setVisible(true);
				vl.setVisible(false);
				return true;
			}
		}
		return false;
	}
}
