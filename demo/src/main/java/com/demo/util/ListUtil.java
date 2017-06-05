package com.demo.util;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
public class ListUtil {
		public static List<String> formatRsToList(ResultSet rs)throws Exception{
			ResultSetMetaData md=rs.getMetaData();
			int num=md.getColumnCount();
			List<String> list = new ArrayList<String>();
			while(rs.next()){
				for(int i=1;i<=num;i++){
//					mapOfColValues.put(md.getColumnName(i), rs.getObject(i));
					list.add(rs.getString(i));
				}
			}
			return list;
		}
	}

