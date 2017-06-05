package com.demo.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.demo.dao.*;
import com.demo.model.*;
public class GoodsDaoImpl implements GoodsDao{
	
public ResultSet list(Connection con,PageBean pageBean) throws Exception{
	String sql="select * from goods limit ?,?";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setInt(1,pageBean.getStart());
	pstmt.setInt(2,pageBean.getRows());
	return pstmt.executeQuery();
}
public ResultSet goodsidSearch(Connection con,String goodscode) throws Exception{
	String sql = "select productid from hivegoodstest where goodsid=?";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setString(1, goodscode);
	return pstmt.executeQuery();
}

public ResultSet idList(Connection con) throws Exception{
	String sql="select id,CONCAT(id,' : ',goods_name) as cnt from goods";
	PreparedStatement pstmt=con.prepareStatement(sql);
	return pstmt.executeQuery();
}

public int count(Connection con)throws Exception{
	String sql ="select count(*) as total from goods";
	PreparedStatement pstmt=con.prepareStatement(sql);
	ResultSet rs=pstmt.executeQuery();
	if(rs.next()){
		return rs.getInt("total");
	}else{
		return 0;
	}
}

public int delete(Connection con,String delId) throws Exception{
	String sql="delete from goods where id =?";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setString(1, delId);
	return pstmt.executeUpdate();
}
public int add(Connection con,Goods goods)throws Exception{
	String sql="insert into goods values(null,?,?,?,?)";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setString(1, goods.getName());
	pstmt.setString(2, goods.getCode());
	pstmt.setString(3, goods.getOther());
	pstmt.setInt(4,goods.getProduct_id());
	return pstmt.executeUpdate();
}
public int modify(Connection con,Goods goods)throws Exception{
	String sql="update goods set goods_name=?,goods_code=?,goods_other=?,products_id=? where id=?";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setString(1, goods.getName());
	pstmt.setString(2, goods.getCode());
	pstmt.setString(3, goods.getOther());
	pstmt.setInt(4,goods.getProduct_id());
	pstmt.setInt(5,goods.getId());
	return pstmt.executeUpdate();
}


}
