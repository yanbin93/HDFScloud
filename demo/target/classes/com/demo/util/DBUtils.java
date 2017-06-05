package com.demo.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import model.GetProperties;

public class DBUtils {
	
		
	//获得连接
	public  Connection createConn2(){
		Connection conn = null; 
		String name="/home/yanbin/workspace/yanbin/src/jdbc.properties";
		GetProperties props=new GetProperties();
		try {
			Class.forName(GetProperties.getProperties("driver",name));
			//ip地址 + 数据库名称
			conn = DriverManager.getConnection(props.getProperties("url", name),props.getProperties("username",name), GetProperties.getProperties("password",name));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return conn;
	}
	public  static Connection createConn(){
		Connection conn = null; 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//ip地址 + 数据库名称
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "0000");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return conn;
	}
	//编译执行
	public static PreparedStatement getPs(Connection conn , String sql){
		PreparedStatement ps = null; 
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps ; 
	}

	public static void close(Connection conn){
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}
	
	public static void close(ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(PreparedStatement ps){
		if(ps != null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	
}
