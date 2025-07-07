package connection;

public interface configurable {
	public final String ip="localhost",
						port="3306",
						name_bbdd="tienda_p66",
						user="root",
						psw="root",
						driver="com.mysql.cj.jdbc.Driver";
	/**
	 * URL
	 * jdbc:mysql: //localhost:3306/tienda_p66?user=root
	 * &password=root&useSSL=false&serverTimezone=UTC
	 */
	public default String getURL() {
		return String.format("jdbc:mysql://%s:%s/%s?user=%s&password=%s"
				+ "&useSSL=false&serverTimezone=UTC", 
				ip,port,name_bbdd,user,psw);
	}
	
	
}
