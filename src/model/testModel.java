package model;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class testModel {

	public static void main(String[] args) {
//		userDAO udao1=new userDAO(new user("admin","admin1234",1));
//		userDAO udao2=new userDAO(new user("ventas","ventas1234",2));
//		
//		try {
//			udao1.writeFileUser();
//			udao2.writeFileUser();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		userDAO udao=new userDAO();
//		try {
//			List<user>users=udao.getUser();
//			for(user u:users) {
//				System.out.println(u.getUser());
//			}
//		}catch (IOException e){
//			e.printStackTrace();
//		}
//		userDAO2 udao2=new userDAO2();
//		List<user> users= udao2.getUser();
//		for(user u:users) {
//			System.out.println(u.getUser());
//		}
		
		productDAO pdao=new productDAO(new product (1,"Ipad","C001",3,398.55,new Date()));
		pdao.updateProduct();
		
		
	}

}
