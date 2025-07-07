package model;

import java.util.Date;

import libreriaGenerica.generic;

public class product {
	private generic <Integer, String> dt1_p;
	private generic <Double,Date> dt2_p;
	
	public product() {
		super();
		
	}
	
	public product(int id_product, String name_product, String cod_product, int stock, double price,Date create ) {
		dt1_p=new generic<> (id_product, stock,name_product,cod_product);
		dt2_p=new generic<>(price,create);
	}
	
	public int getId_product() {
		return dt1_p.getAttribute1();
	}
	public void setId_product(int id) {
		dt1_p.setAttribute1(id);
	}
	 
	public int getStock() {
		return dt1_p.getAttribute2();
	}
	public void setStock(int S) {
		dt1_p.setAttribute2(S);
	}
	
	public String getName_product() {
		return dt1_p.getAttribute3();
	}
	public void setName_product(String name) {
		dt1_p.setAttribute3(name);
	}
	
	public String getCod_product() {
		return dt1_p.getAttribute4();
	}
	public void setCod_product(String cod) {
		dt1_p.setAttribute4(cod);
	}
	
	public double getPrice() {
		return dt2_p.getAttribute1();
	}
	public void setprice(double p) {
		dt2_p.setAttribute1(p);
	}
	public Date getCreate() {
		return dt2_p.getAttribute3();
	}
	public void setCreate(Date c) {
		dt2_p.setAttribute3(c);
	}
}