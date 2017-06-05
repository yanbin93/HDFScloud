package com.demo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.demo.dao.ManufacturersDao;
import com.demo.model.PageBean;
import com.demo.model.Manufacturers;

public class ManufacturersDaoImpl implements ManufacturersDao{
	public ResultSet list(Connection con,PageBean pageBean) throws Exception{
		String sql="select * from manufacturers limit ?,? ";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1,pageBean.getStart());
		pstmt.setInt(2,pageBean.getRows());
		return pstmt.executeQuery();
	}

	public ResultSet idList(Connection con) throws Exception{
		String sql="select id ,CONCAT(id,' : ',manufacturer_name) as cnt from manufacturers";
		PreparedStatement pstmt=con.prepareStatement(sql);
		return pstmt.executeQuery();
	}
	
	public ResultSet idSearch(Connection con,int id) throws Exception{
		String sql="select * from manufacturers where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1,id);
		return pstmt.executeQuery();
	}
	
	public int count(Connection con)throws Exception{
		String sql ="select count(*) as total from manufacturers";
		PreparedStatement pstmt=con.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("total");
		}else{
			return 0;
		}
	}

	public int delete(Connection con,String delId) throws Exception{
		String sql="delete from manufacturers where id =?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, delId);
		return pstmt.executeUpdate();
	}
	public int add(Connection con,Manufacturers manufacturers)throws Exception{
		String sql="insert into manufacturers values(null,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, manufacturers.getName());
		pstmt.setString(2, manufacturers.getCode());
		pstmt.setString(3, manufacturers.getType());
		pstmt.setString(4, manufacturers.getPermit_starttime());
		pstmt.setString(5, manufacturers.getPermit_endtime());
		pstmt.setString(6, manufacturers.getPermit_range());
		pstmt.setString(7, manufacturers.getPermit_pic());
		pstmt.setString(8, manufacturers.getOther());
		pstmt.setInt(9,manufacturers.getSeller_id());
		pstmt.setInt(10, manufacturers.getSupplier_id());
		return pstmt.executeUpdate();
	}
	public int modify(Connection con,Manufacturers manufacturers)throws Exception{
		String sql="update manufacturers set manufacturer_name=?,manufacturer_code=?,manufacturer_type=?,manufacturer_permit_starttime=?,manufacturer_permit_endtime=?,manufacturer_permit_range=?,manufacturer_permit_pic=?,manufacturer_other=?,seller_id=?,supplier_id=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, manufacturers.getName());
		pstmt.setString(2, manufacturers.getCode());
		pstmt.setString(3, manufacturers.getType());
		pstmt.setString(4, manufacturers.getPermit_starttime());
		pstmt.setString(5, manufacturers.getPermit_endtime());
		pstmt.setString(6, manufacturers.getPermit_range());
		pstmt.setString(7, manufacturers.getPermit_pic());
		pstmt.setString(8, manufacturers.getOther());
		pstmt.setInt(9,manufacturers.getSeller_id());
		pstmt.setInt(10, manufacturers.getSupplier_id());
		pstmt.setInt(11, manufacturers.getId());
		return pstmt.executeUpdate();
	}

}
