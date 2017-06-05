package com.demo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.demo.model.PageBean;
import com.demo.model.Products;
import com.demo.dao.*;

public class ProductsDaoImpl implements ProductsDao{
	
public ResultSet list(Connection con,PageBean pageBean) throws Exception{
	String sql="select * from products limit ?,?";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setInt(1,pageBean.getStart());
	pstmt.setInt(2,pageBean.getRows());
	return pstmt.executeQuery();
}

public ResultSet idList(Connection con) throws Exception{
	String sql="select id ,CONCAT(id,' : ',products_name) as cnt from products";
	PreparedStatement pstmt=con.prepareStatement(sql);
	return pstmt.executeQuery();
}

public ResultSet query(Connection con,String sql) throws Exception{
	PreparedStatement pstmt=con.prepareStatement(sql);
	return pstmt.executeQuery();
}

public ResultSet idSearch(Connection con,int id) throws Exception{
	String sql="select * from products where id=?";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setInt(1,id);
	return pstmt.executeQuery();
}
public ResultSet nameSearch(Connection con,String name) throws Exception{
	String sql="select * from products where products_name=?";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setString(1,name);
	return pstmt.executeQuery();
}

public int count(Connection con)throws Exception{
	String sql ="select count(*) as total from products";
	PreparedStatement pstmt=con.prepareStatement(sql);
	ResultSet rs=pstmt.executeQuery();
	if(rs.next()){
		return rs.getInt("total");
	}else{
		return 0;
	}
}

public int delete(Connection con,String delId) throws Exception{
	String sql="delete from products where id =?";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setString(1, delId);
	return pstmt.executeUpdate();
}
public int add(Connection con,Products products)throws Exception{
	String sql="insert into products values(null,?,?,?,?,?)";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setString(1, products.getName());
	pstmt.setString(2, products.getOther());
	pstmt.setInt(3, products.getManufacturer_id());
	pstmt.setInt(4,products.getSeller_id());
	pstmt.setInt(5, products.getSupplier_id());
	return pstmt.executeUpdate();
}
public int modify(Connection con,Products products)throws Exception{
	String sql="update products set products_name=?,products_other=?,manufacturer_id=?,seller_id=?,supplier_id=? where id=?";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setString(1, products.getName());
	pstmt.setString(2, products.getOther());
	pstmt.setInt(3, products.getManufacturer_id());
	pstmt.setInt(4,products.getSeller_id());
	pstmt.setInt(5,products.getSupplier_id());
	pstmt.setInt(6,products.getId());
	return pstmt.executeUpdate();
}

}
