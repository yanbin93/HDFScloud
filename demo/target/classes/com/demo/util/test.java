package com.demo.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Properties;

import com.demo.dao.impl.GoodsDaoImpl;
import com.demo.factory.DAOFactory;

import model.GetProperties;

public class test {
//	private static Properties props = new Properties();
//	static{
//		InputStream is = null;
//		is = DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
//		try {
//			System.out.println("???");
//			props.load(is);
//			System.out.println("!!!");
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally{
//			if(is!=null){
//				try {
//					is.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//			}
//	}
public static void main(String[] args) throws Exception{
//	DBUtils dbUtil = new DBUtils();
//	GoodsDaoImpl goodsDao = DAOFactory.getGoodsDaoInstance();
//	ResultSet rs=goodsDao.query(dbUtil.createConn2(), "select products_id from goods where id=1");
//	while(rs.next()){
//		ResultSetMetaData md= rs.getMetaData();
//		System.out.println(md.getColumnCount()+md.getColumnDisplaySize(1)+"  "+md.getColumnType(1)
//		+" "+md.getScale(1)+" "+md.getSchemaName(1)+" "+md.getColumnLabel(1)
//				
//				);
	}
//	System.out.println((String)props.get("url")+(String)props.get("username")+(String)props.get("password"));
//	Connection con=dbutil.createConn2();
//	String result = GetProperties.getProperties2("url", "jdbc.properties");
//	if(con!=null){System.out.println("成功 ");}
//	else{System.out.println("失败");}

}
