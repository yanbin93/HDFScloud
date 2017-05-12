package com.hdfscloud.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

/**
 * Servlet implementation class Test
 */
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bath = request.getSession().getServletContext().getRealPath("");
        
        String fileDownloadName = null; // 下载的文件的物理路径＋文件名
        String s_filename=request.getParameter("filename");
        String isDir=request.getParameter("isDir");
        if((s_filename!=null)&&(isDir.equals("File"))){
        	fileDownloadName=s_filename;
        }
        String fileDisplayName = fileDownloadName;
        if (fileDownloadName.length()>=18){
        	fileDisplayName=fileDownloadName.substring(19, fileDownloadName.length()); // 给用户提供的下载文件名
        }
        response.addHeader("Content-Disposition", "attachment;filename=" + fileDisplayName);
        OutputStream outp = null;
        FSDataInputStream in = null;
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(fileDownloadName), conf);
        try {
            outp = response.getOutputStream();
           // in = new FileInputStream(fileDownloadName);
            in =fs.open(new Path(fileDownloadName));
            IOUtils.copyBytes(in, outp, 4096, false);
            in.seek(0); // go back to the start of the file
            IOUtils.copyBytes(in, System.out, 4096, false);
            } catch (Exception e)
        {
                System.out.println("文件下载失败!");
                e.printStackTrace();
            }finally {
            IOUtils.closeStream(in);
            if (in != null) {
                in.close();
                in = null;
            }
            if (outp != null) {
                outp.close();
                outp = null;
            }
            }
            
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
