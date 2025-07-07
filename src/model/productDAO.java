package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import connection.query;

public class productDAO {
	private product p;
	private query q=new query();

	public productDAO(product p) {
		super();
		this.p = p;
	}

	public productDAO() {
		super();
		p=new product();
	}
	public boolean addProduct() {
		return q.queryUpdate(String.format("INSERT INTO tienda_p66.product VALUES(null,'%s','%s',%d , %s, '%s');",
				p.getName_product(),p.getCod_product(),p.getStock(),String.valueOf(p.getPrice()),"2025-07-03"));
//		System.out.println(String.format("INSERT INTO tienda_p66.product VALUES(null,'%s','%s',%d , %s, '%s');",
//				p.getName_product(),p.getCod_product(),p.getStock(),String.valueOf(p.getPrice()),"2025-07-03"));
//		return true;
	}
	public boolean updateProduct() {
		return q.queryUpdate(String.format("UPDATE tienda_p66.product SET name_Product= '%s', cod_product= '%s',stock= %d, price= %s "
						+ "WHERE id_product= %d",
				p.getName_product(),p.getCod_product(),p.getStock(),String.valueOf(p.getPrice()),p.getId_product()));
	}

	public List<product> getAllProducts() {
		List<product> products = new ArrayList<>();
		ResultSet res = q.queryRest("SELECT id_product, name_product, cod_product, stock, price, `create` FROM tienda_p66.product;");
		try {
			while (res.next()) {
				int id = res.getInt("id_product");
				String name = res.getString("name_product");
				String cod = res.getString("cod_product");
				int stock = res.getInt("stock");
				double price = res.getDouble("price");
				Date create = res.getDate("create");
				products.add(new product(id, name, cod, stock, price, create));
			}
			q.closeConn();
		} catch (SQLException ex) {
			System.err.println("Error al consultar la base de datos para productos: " + ex.getMessage());
			ex.printStackTrace();
		}
		return products;
	}

	public boolean deleteProduct() {
		return q.queryUpdate(String.format("DELETE FROM tienda_p66.product WHERE id_product = %d;", p.getId_product()));
	}
}