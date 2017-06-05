package com.demo.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class RsToStringUtil {
	public static String formatRsToString(ResultSet rs)throws Exception{
		ResultSetMetaData md=rs.getMetaData();
		int num=md.getColumnCount();
		String str="";
		while(rs.next()){
			for(int i=1;i<=num;i++){
//				mapOfColValues.put(md.getColumnName(i), rs.getObject(i));
				str+=md.getColumnName(i)+" : "+rs.getString(i)+"<br>";
			}
		}
		return str;
	}
}
