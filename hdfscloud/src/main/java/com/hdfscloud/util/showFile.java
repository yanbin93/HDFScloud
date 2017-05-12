package com.hdfscloud.util;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;

import com.hdfscloud.model.File;

public class showFile{
	final Configuration conf = new Configuration();
	static FileSystem fs;
	private static String HADOOP_URL=null;
	static{
		try {
			HADOOP_URL=GetProperties.getProperties("HADOOP_URL");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	
	public ArrayList<File> show(String dirname) throws Exception{
//	?dirname = "/hive";
	fs = FileSystem.get(new URI(HADOOP_URL), conf);
	FileStatus [] statuses=HDFSUtil.listStatus(conf, dirname);
	ArrayList<File> files = new ArrayList<File>();
	for (FileStatus status:statuses){
			File file = new File();
			long size=status.getLen();
			Path name=status.getPath();
			String type = status.isDirectory()?"Dir":"File";
			file.setSize(size);
			file.setName(name.toString());
			file.setType(type);
			files.add(file);
			System.out.println(name+ " " +Long.toString(size)+"B "+type);

	}
    return files;
	}


	public ArrayList<File> showSomeone(String filename) throws Exception{
	fs = FileSystem.get(new URI(HADOOP_URL), conf);
	RemoteIterator<LocatedFileStatus> statuses = HDFSUtil.listFiles(fs, "/",true);
	ArrayList<File> filter = new ArrayList<File>();
	while(statuses.hasNext()){
		LocatedFileStatus status = statuses.next();	
		System.out.println(status.getPath().getName());
		if (status.getPath().getName().equals(filename)){
				File file = new File();
				long size=status.getLen();
				Path name=status.getPath();
				String type = status.isDirectory()?"Dir":"File";
				file.setSize(size);
				file.setName(name.toString());
				file.setType(type);
				filter.add(file);
				System.out.println(name+ " " +Long.toString(size)+"B "+type);
		}
	}
	    return filter;
	}

	public ArrayList<File> showSometype(List<String> types,String range) throws Exception{
	fs = FileSystem.get(new URI(HADOOP_URL), conf);
	RemoteIterator<LocatedFileStatus> statuses = HDFSUtil.listFiles(fs, range,true);
	ArrayList<File> filter = new ArrayList<File>();
	while(statuses.hasNext()){
		LocatedFileStatus status = statuses.next();	
		String[] tmp=status.getPath().getName().split("\\.");
		if (tmp.length>=1){
			String tmptype=tmp[tmp.length-1];
		if (types.contains(tmptype)){
				File file = new File();
				long size=status.getLen();
				Path name=status.getPath();
				String type = status.isDirectory()?"Dir":"File";
				file.setSize(size);
				file.setName(name.toString());
				file.setType(type);
				filter.add(file);
				System.out.println(name.getName()+ " " +Long.toString(size)+"B "+type);
		}
		}
	}
	    return filter;
	}

	public String showFile(String filename) throws Exception{
	fs = FileSystem.get(new URI(HADOOP_URL), conf);
	String content = HDFSUtil.readFile(conf, filename);
	return content;
}
	
public boolean deleteFile(String filename) throws Exception{
	boolean result= HDFSUtil.deleteFile(conf, filename,true);
	return result;
}
public boolean createDir(String newDir) throws Exception{
	boolean result= HDFSUtil.createDirectory(conf, newDir);
	return result;
}
}
