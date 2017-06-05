package com.demo.spark;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test {
	    public static void main(String[] args){  
	        InputStream in = null;  
	        try {  
	            Process pro = Runtime.getRuntime().exec(new String[]{"/bin/bash",  
	                                     "-c","ls ~/"});  
	            pro.waitFor();  
	            in = pro.getInputStream();  
	            BufferedReader read = new BufferedReader(new InputStreamReader(in));  
	            String line = null;  
	            while((line = read.readLine())!=null){  
	                System.out.println(line);  
	            }  
 
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	    }  
}
