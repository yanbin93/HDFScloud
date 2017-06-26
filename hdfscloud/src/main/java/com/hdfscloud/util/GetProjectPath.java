package com.hdfscloud.util;

import java.io.File;

public class GetProjectPath {
	public static void main(String[] args) throws Exception {
		System.out.println(getPath());
		String projectPath = GetProjectPath.getPath();
		String name="/src/hadoop.properties";
		String propertyName=projectPath+name;
		System.out.println(propertyName);
		String path = GetProjectPath.class.getClassLoader().toString();
		System.out.println(path);
	}
	public static String getPath() throws Exception{
    File directory = new File("");// 参数为空
    String courseFile = directory.getCanonicalPath();
    return courseFile.toString();
	}
}
