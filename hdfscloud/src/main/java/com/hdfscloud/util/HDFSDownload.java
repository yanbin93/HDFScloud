package com.hdfscloud.util;
import java.io.File;  
import java.io.FileOutputStream;  
import java.net.URI;  
import org.apache.hadoop.conf.Configuration;  
import org.apache.hadoop.fs.FileSystem;  
import org.apache.hadoop.fs.FSDataInputStream;  
import org.apache.hadoop.fs.FileUtil;  
import org.apache.hadoop.fs.Path;  
import org.apache.hadoop.fs.FileStatus;  
import org.apache.hadoop.io.IOUtils;

  
public class HDFSDownload  
{  
    final static Configuration conf = new Configuration();
	static FileSystem hdfs = null;
	private static String HADOOP_URL=null;
	static{
		try {
			HADOOP_URL=GetProperties.getProperties("HADOOP_URL");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
      
    public static void downloadFile(String srcPath, String dstPath) throws Exception  
    {  
        FSDataInputStream in = null;  
        FileOutputStream out = null;  
        try  
        {  
            in = hdfs.open(new Path(srcPath));  
            out = new FileOutputStream(dstPath);  
            IOUtils.copyBytes(in, out, 4096, false);  
            
        }  
        finally  
        {  
            IOUtils.closeStream(in);  
            IOUtils.closeStream(out);  
        }  
    }  
      
    public static void downloadFolder(String srcPath, String dstPath) throws Exception  
    {  
        File dstDir = new File(dstPath);  
        if (!dstDir.exists())  
        {  
            dstDir.mkdirs();  
        }  
        FileStatus[] srcFileStatus = hdfs.listStatus(new Path(srcPath));  
        Path[] srcFilePath = FileUtil.stat2Paths(srcFileStatus);  
        for (int i = 0; i < srcFilePath.length; i++)  
        {  
            String srcFile = srcFilePath[i].toString();  
            int fileNamePosi = srcFile.lastIndexOf('/');  
            String fileName = srcFile.substring(fileNamePosi + 1);  
            download(srcPath + '/' + fileName, dstPath + '/' + fileName);  
        }  
    }  
      
    public static void download(String srcPath, String dstPath) throws Exception  
    {  
        if (hdfs.isFile(new Path(srcPath)))  
        {  
            downloadFile(srcPath, dstPath);  
        }  
        else  
        {  
            downloadFolder(srcPath, dstPath);  
        }  
    }  
      
    public static boolean downloadAll(String srcPath,String localpath)  
    {  
            try  
            {  
                Configuration conf = new Configuration();  
                hdfs = FileSystem.get(URI.create(HADOOP_URL), conf);  
                System.out.println(srcPath+"  "+localpath);
                download(srcPath, localpath);  
            }  
            catch (Exception e)  
            {  
            	
                System.out.println(e+"Error occured when copy files");  
                return false;
            }  
            return true;
          
    }
    public static void main(String[] args){
    	System.out.println(downloadAll("/tmp" ,"/home/yanbin/桌面/"));
    }
}  