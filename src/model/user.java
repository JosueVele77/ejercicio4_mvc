package model;

import libreriaGenerica.generic;

public class user {
	private generic<String, Integer>dt_u;
	public user(String u, String psw, int type) {
		dt_u=new generic<>(u,psw,type);
	}
	public void setPsw(String psw) {
		this.dt_u.setAttribute2(psw);;
	}
	public String getPsw() {
		return dt_u.getAttribute2();
	}
	public void setType(int t) {
		this.dt_u.setAttribute3(t);;
	}
	public int getType() {
		return dt_u.getAttribute3();
	}
	public void setUser(String u) {
		this.dt_u.setAttribute1(u);;
	}
	public String getUser() {
		return dt_u.getAttribute1();
	}
	public String infoUser() {
		return String.format("%s;%s;%d", getUser(),getPsw(),getType());
	}
	
}
