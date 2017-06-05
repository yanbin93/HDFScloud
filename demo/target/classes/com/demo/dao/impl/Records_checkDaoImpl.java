package com.demo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.demo.dao.Records_checkDao;
import com.demo.model.PageBean;
import com.demo.model.Records_check;

public class Records_checkDaoImpl implements Records_checkDao{
	
public ResultSet list(Connection con,PageBean pageBean) throws Exception{
	String sql="select * from records_check limit ?,?";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setInt(1,pageBean.getStart());
	pstmt.setInt(2,pageBean.getRows());
	return pstmt.executeQuery();
}

public ResultSet idList(Connection con) throws Exception{
	String sql="select id ,CONCAT(id,' : ',check_name) as cnt from records_check";
	PreparedStatement pstmt=con.prepareStatement(sql);
	return pstmt.executeQuery();
}

public int count(Connection con)throws Exception{
	String sql ="select count(*) as total from records_check";
	PreparedStatement pstmt=con.prepareStatement(sql);
	ResultSet rs=pstmt.executeQuery();
	if(rs.next()){
		return rs.getInt("total");
	}else{
		return 0;
	}
}

public int delete(Connection con,String delId) throws Exception{
	String sql="delete from records_check where id =?";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setString(1, delId);
	return pstmt.executeUpdate();
}
public int add(Connection con,Records_check records_check)throws Exception{
	String sql="insert into records_check values(null,?,?,?)";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setString(1, records_check.getName());
	pstmt.setString(2, records_check.getResults());
	pstmt.setInt(3, records_check.getProdicts_id());
	return pstmt.executeUpdate();
}
public int modify(Connection con,Records_check records_check)throws Exception{
	String sql="update records_check set check_name=?,check_results=?,products_id=? where id=?";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setString(1, records_check.getName());
	pstmt.setString(2, records_check.getResults());
	pstmt.setInt(3, records_check.getProdicts_id());
	pstmt.setInt(4,records_check.getId());
	return pstmt.executeUpdate();
}
}
