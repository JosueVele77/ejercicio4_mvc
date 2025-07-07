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
		// AYUDAAAAAAAA - Removed the problematic initialization here
	}

	public List<user> getUser(){
		List <user> users=new ArrayList<>();
		ResultSet res= q.queryRest("SELECT * FROM tiendap66.user;");
		try {
			// Verificar si el ResultSet es nulo antes de intentar usarlo
			if (res != null) {
				while(res.next()) {
					// Create a new user object for each row
					user currentUser = new user(res.getString(2), res.getString(3), res.getInt(4));
					users.add(currentUser);
				}
				q.closeConn();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
}