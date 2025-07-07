package model;

import libreriaGenerica.generic;

public class person {
	private generic <String,Integer> dt_p;
	public person(String name, int dni, String email) {
		dt_p=new generic<>(name,email,dni);
	}
	//getters y setters
	public String getName() {
		return dt_p.getAttribute1();
	}
	public void setName(String name) {
		dt_p.setAttribute1(name);
	}
	public String getEmail() {
		return dt_p.getAttribute2();
	}
	public void setEmail(String email) {
		dt_p.setAttribute2(email);
	}
	public int getDni() {
		return dt_p.getAttribute3();
	}
	public void setDni(int dni) {
		dt_p.setAttribute3(dni);
	}
	public String infoPerson() {
		//nombre;cedula;email
		return String.format("%s,%d,%s",getName(),getDni(),getEmail());
	}
}
