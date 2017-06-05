package com.demo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.demo.model.PageBean;
import com.demo.model.Stocks;

public class StocksDaoImpl {
	public ResultSet list(Connection con,PageBean pageBean) throws Exception{
		String sql="select * from stocks limit ?,?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1,pageBean.getStart());
		pstmt.setInt(2,pageBean.getRows());
		return pstmt.executeQuery();
	}

	public ResultSet idList(Connection con) throws Exception{
		String sql="select id ,CONCAT(id,' : ',stocks_name) as cnt from stocks";
		PreparedStatement pstmt=con.prepareStatement(sql);
		return pstmt.executeQuery();
	}

	public int count(Connection con)throws Exception{
		String sql ="select count(*) as total from stocks";
		PreparedStatement pstmt=con.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("total");
		}else{
			return 0;
		}
	}

	public int delete(Connection con,String delId) throws Exception{
		String sql="delete from stocks where id =?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, delId);
		return pstmt.executeUpdate();
	}
	public int add(Connection con,Stocks stocks)throws Exception{
		String sql="insert into stocks values(null,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, stocks.getName());
		pstmt.setString(2, stocks.getCode());
		pstmt.setString (3, stocks.getPerson());
		pstmt.setString(4, stocks.getData());
		pstmt.setString(5, stocks.getQuantity());
		pstmt.setString(6, stocks.getCheckresult());
		pstmt.setInt(7, stocks.getSupplier_id());
		return pstmt.executeUpdate();
	}
	public int modify(Connection con,Stocks stocks)throws Exception{
		String sql="update stocks set stocks_name=?,stocks_code=?,stocks_person=?,stocks_data=?,stocks_quantity=?,stocks_checkresult=?,suppliers_id=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, stocks.getName());
		pstmt.setString(2, stocks.getCode());
		pstmt.setString (3, stocks.getPerson());
		pstmt.setString(4, stocks.getData());
		pstmt.setString(5, stocks.getQuantity());
		pstmt.setString(6, stocks.getCheckresult());
		pstmt.setInt(7, stocks.getSupplier_id());
		pstmt.setInt(8,stocks.getId());
		return pstmt.executeUpdate();
	}

}
