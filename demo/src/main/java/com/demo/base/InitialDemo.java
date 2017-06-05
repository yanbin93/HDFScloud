package com.demo.base;
import java.io.*;
import com.demo.util.GetPath;
public class InitialDemo {
		public static void main(String[] args) throws Exception {
			GetPath getPath = new GetPath();
			String path =getPath.showPath();
	        FileOutputStream out = null;   
	        FileOutputStream outSTr = null;   
	        BufferedOutputStream Buff=null;   
	        FileWriter fw = null;   
	        try {   
	            out = new FileOutputStream(new File(path+"/src/path.properties"));   
	           out.write(("path="+path+"/src/").getBytes());   
	        }finally{
	            out.close();}   
			System.out.println(path);
		}
}
