package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.query;

public class userDAO2 {
	private user u;
	private query q= new query();
	public userDAO2(user u) {
		super();
		this.u = u;
	}

	public userDAO2() {
		super();
		//AYUDAAAAAAAA
		u=new user(null, null, 0);
	}
	
	public List<user> getUser(){
		List <user> users=new ArrayList<>();
		ResultSet res= q.queryRest("SELECT * FROM tienda_p66.user;");
		try {
			while(res.next()) {
				u=new user(null, null, 0);
				u.setUser(res.getString(2));
				u.setPsw(res.getString(3));
				u.setType(res.getInt(4));
				users.add(u);
			}
			q.closeConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
}
