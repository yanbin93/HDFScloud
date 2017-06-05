package com.demo.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProperties {
	private static String propertyName="/home/yanbin/workspace/demo/src/hadoop.properties";
	public static String getProperties(String key)throws Exception{
	    String property=null;
	    Properties pps = new Properties();
        pps.load(new FileInputStream(propertyName));
        property=pps.getProperty(key).toString();
        return property;
	    }	
	public static String getProperties(String key,String propertyName)throws Exception{
	    String property=null;
	    Properties pps = new Properties();
        pps.load(new FileInputStream(propertyName));
        property=pps.getProperty(key).toString();
        return property;
	    }	
	
	public static String getProperties2(String key,String name){
	Properties props = new Properties();
		InputStream is = null;
	is = GetProperties.class.getClassLoader().getResourceAsStream(name);
	try {
		System.out.println("???");
		props.load(is);
		System.out.println("!!!");
		return props.getProperty(key);
	} catch (IOException e) {
		e.printStackTrace();
	} finally{
		if(is!=null){
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	return null;
}

}
