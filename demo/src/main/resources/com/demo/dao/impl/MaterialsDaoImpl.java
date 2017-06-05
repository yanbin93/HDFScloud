package com.demo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.demo.dao.MaterialsDao;
import com.demo.model.Materials;
import com.demo.model.PageBean;

public class MaterialsDaoImpl implements MaterialsDao{
	public ResultSet list(Connection con,PageBean pageBean) throws Exception{
		String sql="select * from materials limit ?,?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1,pageBean.getStart());
		pstmt.setInt(2,pageBean.getRows());
		return pstmt.executeQuery();
	}
		public ResultSet idSearch(Connection con,int id) throws Exception{
			String sql="select * from materials where products_id=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,id);
			return pstmt.executeQuery();
		}
	
	public ResultSet idList(Connection con) throws Exception{
		String sql="select id ,CONCAT(id,' : ',materials_name) as cnt from materials";
		PreparedStatement pstmt=con.prepareStatement(sql);
		return pstmt.executeQuery();
	}

	public int count(Connection con)throws Exception{
		String sql ="select count(*) as total from materials";
		PreparedStatement pstmt=con.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("total");
		}else{
			return 0;
		}
	}

	public int delete(Connection con,String delId) throws Exception{
		String sql="delete from materials where id =?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, delId);
		return pstmt.executeUpdate();
	}
	public int add(Connection con,Materials materials)throws Exception{
		String sql="insert into materials values(null,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, materials.getName());
		pstmt.setString(2, materials.getQuantity());
		pstmt.setInt(3, materials.getStocks_id());
		pstmt.setInt(4,materials.getProducts_id());
		return pstmt.executeUpdate();
	}
	public int modify(Connection con,Materials materials)throws Exception{
		String sql="update materials set materials_name=?,materials_quantity=?,stocks_id=?,products_id=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, materials.getName());
		pstmt.setString(2, materials.getQuantity());
		pstmt.setInt(3, materials.getStocks_id());
		pstmt.setInt(4,materials.getProducts_id());
		pstmt.setInt(5,materials.getId());
		return pstmt.executeUpdate();
	}

}
