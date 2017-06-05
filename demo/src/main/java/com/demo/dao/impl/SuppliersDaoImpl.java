package com.demo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.demo.dao.SuppliersDao;
import com.demo.model.PageBean;
import com.demo.model.Sellers;
import com.demo.model.Suppliers;

public class SuppliersDaoImpl implements SuppliersDao{
	
public ResultSet list(Connection con,PageBean pageBean) throws Exception{
	String sql="select * from suppliers limit ?,?";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setInt(1,pageBean.getStart());
	pstmt.setInt(2,pageBean.getRows());
	return pstmt.executeQuery();
}
public ResultSet idSearch(Connection con,int id) throws Exception{
	String sql="select * from suppliers where id=?";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setInt(1,id);
	return pstmt.executeQuery();
}
public ResultSet idList(Connection con) throws Exception{
	String sql="select id ,CONCAT(id,' : ',supplier_name) as cnt from suppliers";
	PreparedStatement pstmt=con.prepareStatement(sql);
	return pstmt.executeQuery();
}

public int count(Connection con)throws Exception{
	String sql ="select count(*) as total from suppliers";
	PreparedStatement pstmt=con.prepareStatement(sql);
	ResultSet rs=pstmt.executeQuery();
	if(rs.next()){
		return rs.getInt("total");
	}else{
		return 0;
	}
}

public int delete(Connection con,String delId) throws Exception{
	String sql="delete from suppliers where id =?";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setString(1, delId);
	return pstmt.executeUpdate();
}
public int add(Connection con,Suppliers suppliers)throws Exception{
	String sql="insert into suppliers values(null,?,?,?,?,?,?,?,?)";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setString(1, suppliers.getName());
	pstmt.setString(2, suppliers.getPemit());
	pstmt.setString(3, suppliers.getCode());
	pstmt.setString(4, suppliers.getAddress());
	pstmt.setString(5, suppliers.getPhone());
	pstmt.setString(6, suppliers.getMail());
	pstmt.setString(7, suppliers.getContact());
	pstmt.setString(8, suppliers.getOther());
	return pstmt.executeUpdate();
}
public int modify(Connection con,Suppliers suppliers)throws Exception{
	String sql="update suppliers set supplier_name=?,supplier_permit=?,supplier_code=?,supplier_address=?,supplier_phone=?,supplier_mail=?,supplier_contact=?,supplier_other=? where id=?";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setString(1, suppliers.getName());
	pstmt.setString(2, suppliers.getPemit());
	pstmt.setString(3, suppliers.getCode());
	pstmt.setString(4, suppliers.getAddress());
	pstmt.setString(5, suppliers.getPhone());
	pstmt.setString(6, suppliers.getMail());
	pstmt.setString(7, suppliers.getContact());
	pstmt.setString(8, suppliers.getOther());
	pstmt.setInt(9, suppliers.getId());
	return pstmt.executeUpdate();
}

}
