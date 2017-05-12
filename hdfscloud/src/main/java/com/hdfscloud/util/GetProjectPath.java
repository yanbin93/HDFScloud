package com.hdfscloud.util;

import java.io.File;

public class GetProjectPath {
	public static void main(String[] args) throws Exception {
		System.out.println(getPath());
	}
	public static String getPath() throws Exception{
    File directory = new File("");// 参数为空
    String courseFile = directory.getCanonicalPath();
    return courseFile.toString();
	}
}
