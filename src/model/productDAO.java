package model;

import java.util.Date;

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
}
