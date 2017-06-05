package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.demo.model.PageBean;
import com.demo.model.User;

public class UserDao {
	
public ResultSet userList(Connection con,PageBean pageBean) throws Exception{
	String sql="select * from user limit ?,?";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setInt(1,pageBean.getStart());
	pstmt.setInt(2,pageBean.getRows());
	return pstmt.executeQuery();
}

public int userCount(Connection con)throws Exception{
	String sql ="select count(*) as total from user";
	PreparedStatement pstmt=con.prepareStatement(sql);
	ResultSet rs=pstmt.executeQuery();
	if(rs.next()){
		return rs.getInt("total");
	}else{
		return 0;
	}
}

public int userDelete(Connection con,String delId) throws Exception{
	String sql="delete from user where id =?";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setString(1, delId);
	return pstmt.executeUpdate();
}
public int userAdd(Connection con,User user)throws Exception{
	String sql="insert into user values(null,?,?,?)";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setString(1, user.getName());
	pstmt.setString(2, user.getPassword());
	pstmt.setString(3, user.getEmail());
	return pstmt.executeUpdate();
}
public int userModify(Connection con,User user)throws Exception{
	String sql="update user set usrename=?,password=?,email=? where id=?";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setString(1, user.getName());
	pstmt.setString(2, user.getPassword());
	pstmt.setString(3, user.getEmail());
	pstmt.setInt(4, user.getId());
	return pstmt.executeUpdate();
}

}
