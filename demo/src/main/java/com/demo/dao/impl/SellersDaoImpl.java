package com.demo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.demo.dao.SellersDao;
import com.demo.model.PageBean;
import com.demo.model.Sellers;

public class SellersDaoImpl implements SellersDao{
	
public ResultSet list(Connection con,PageBean pageBean) throws Exception{
	String sql="select * from sellers limit ?,?";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setInt(1,pageBean.getStart());
	pstmt.setInt(2,pageBean.getRows());
	return pstmt.executeQuery();
}
public ResultSet idSearch(Connection con,int id) throws Exception{
	String sql="select * from sellers where id =?";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setInt(1,id);
	return pstmt.executeQuery();
}

public ResultSet idList(Connection con) throws Exception{
	String sql="select id ,CONCAT(id,' : ',seller_name) as cnt from sellers";
	PreparedStatement pstmt=con.prepareStatement(sql);
	return pstmt.executeQuery();
}

public int count(Connection con)throws Exception{
	String sql ="select count(*) as total from sellers";
	PreparedStatement pstmt=con.prepareStatement(sql);
	ResultSet rs=pstmt.executeQuery();
	if(rs.next()){
		return rs.getInt("total");
	}else{
		return 0;
	}
}

public int delete(Connection con,String delId) throws Exception{
	String sql="delete from sellers where id =?";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setString(1, delId);
	return pstmt.executeUpdate();
}
public int add(Connection con,Sellers sellers)throws Exception{
	String sql="insert into sellers values(null,?,?,?,?,?,?,?,?)";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setString(1, sellers.getName());
	pstmt.setString(2, sellers.getPemit());
	pstmt.setString(3, sellers.getCode());
	pstmt.setString(4, sellers.getAddress());
	pstmt.setString(5, sellers.getPhone());
	pstmt.setString(6, sellers.getMail());
	pstmt.setString(7, sellers.getContact());
	pstmt.setString(8, sellers.getOther());
	return pstmt.executeUpdate();
}
public int modify(Connection con,Sellers sellers)throws Exception{
	String sql="update sellers set seller_name=?,seller_permit=?,seller_code=?,seller_address=?,seller_phone=?,seller_mail=?,seller_contact=?,seller_other=? where id=?";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setString(1, sellers.getName());
	pstmt.setString(2, sellers.getPemit());
	pstmt.setString(3, sellers.getCode());
	pstmt.setString(4, sellers.getAddress());
	pstmt.setString(5, sellers.getPhone());
	pstmt.setString(6, sellers.getMail());
	pstmt.setString(7, sellers.getContact());
	pstmt.setString(8, sellers.getOther());
	pstmt.setInt(9, sellers.getId());
	return pstmt.executeUpdate();
}

}
