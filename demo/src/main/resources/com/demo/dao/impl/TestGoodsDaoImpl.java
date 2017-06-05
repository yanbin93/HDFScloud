package com.demo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;

import com.demo.dao.TestGoodsDao;
import com.demo.model.Goods;
import com.demo.model.PageBean;
import com.demo.model.TestGoods;

public class TestGoodsDaoImpl implements TestGoodsDao{
	public ResultSet list(Connection con,PageBean pageBean) throws Exception{
		String sql="select id,productid,productcode,productno,productname from product where id>? and id <= ?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1,pageBean.getStart());
		pstmt.setInt(2,pageBean.getRows()+pageBean.getStart());
		System.out.println(pageBean.getStart());
		System.out.println(pageBean.getRows());
		return pstmt.executeQuery();
	}
	public ResultSet goodsidSearch(Connection con,String goodscode) throws Exception{
		String sql = "select productid from product where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, goodscode);
		return pstmt.executeQuery();
	}

	public ResultSet idList(Connection con) throws Exception{
		String sql="select id,CONCAT(id,' : ',productname) as cnt from product";
		PreparedStatement pstmt=con.prepareStatement(sql);
		return pstmt.executeQuery();
	}

	public int count(Connection con)throws Exception{
		String sql ="select count(*) as total from product";
		PreparedStatement pstmt=con.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("total");
		}else{
			return 0;
		}
	}
	public ResultSet query(Connection con,String sql) throws Exception{
		PreparedStatement pstmt=con.prepareStatement(sql);
		return pstmt.executeQuery();
	}
	
	public int delete(Connection con,String delId) throws Exception{
		String sql="delete from product where id =?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, delId);
		return pstmt.executeUpdate();
	}
	public int add(Connection con,TestGoods testGoods)throws Exception{
		String sql="insert into product values(null,?,?,?,?,null)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1,testGoods.getProductId());
		pstmt.setInt(2,testGoods.getProductCode());
		pstmt.setString(3,testGoods.getProductNo());
		pstmt.setString(4,testGoods.getProductName());
		return pstmt.executeUpdate();
	}
	public int modify(Connection con,TestGoods testGoods)throws Exception{
		String sql="update product set productid=?,productcode=?,productno=?,productname=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1,testGoods.getProductId());
		pstmt.setInt(2,testGoods.getProductCode());
		pstmt.setString(3,testGoods.getProductNo());
		pstmt.setString(4,testGoods.getProductName());
		pstmt.setInt(5, testGoods.getId());
		return pstmt.executeUpdate();
	}
	public ResultSet nameSearch(Connection con, String searchname) throws Exception {
		String sql="select id,productid,productcode,productno,productname from product where productname=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,searchname);
		return pstmt.executeQuery();
	}
	public ResultSet idSearch(Connection con, int id) throws Exception {
		String sql="select id,productid,productcode,productno,productname from product where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1,id);
		return pstmt.executeQuery();
	}
}
