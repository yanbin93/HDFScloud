package com.demo.util;

import java.io.File;

public class GetPath {
	public static String showPath() throws Exception{
	    File directory = new File("");// 参数为空
	    String courseFile = directory.getCanonicalPath();
	    return courseFile.toString();
	}
}
