package connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class query extends connection{
	//INSERT, UPDATE, DELETE
	public boolean queryUpdate(String senSQL) {
		try {
			if (openConn() != null) {
				stmt= (Statement) conn.createStatement();
				stmt.executeUpdate(senSQL);
				return closeConn();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Error en la actualizacion de la bbdd"+e);
		}
		return false;
	}
	//SELECT
	public ResultSet queryRest(String senSQL) {
		try {
			if (openConn() != null) {
				stmt=(Statement)conn.createStatement();
				res= stmt.executeQuery(senSQL);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Error al consultar la bbdd");
		}
		return res;
	}
}