package com.hdfscloud.servlet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hdfscloud.util.showFile;


/**
 * Servlet implementation class DeleteFile
 */
public class DeleteFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("utf-8"); 
		String dirname = null;
		String s_dirname=request.getParameter("dirname");
		if(s_dirname!=null){
			//接收到了pageNow
			dirname=s_dirname;
			}
		boolean result =  false;
		showFile showfile = new showFile();
		try {
			result = showfile.deleteFile(dirname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message","文件删除失败！"+e.getMessage());
		}
		if (result){
			request.setAttribute("message","文件删除成功！");
		}
		System.out.println(dirname);
			String regex = "^hdfs://.*\\d+/";
		   Pattern pat = Pattern.compile(regex);  
		   Matcher matcher = pat.matcher(dirname);     
		   while (matcher.find()) { 
		     String temp = dirname.substring(matcher.start(),matcher.end());
		     dirname = dirname.replaceAll(temp, "/");
		   }   
		   System.out.println(dirname);
		String newdirname=dirname.substring(0, dirname.lastIndexOf("/"));
		if (newdirname.length()<1){newdirname="/";}
		System.out.println(newdirname);
		request.setAttribute("dirname",newdirname);
		System.out.println(result+"  "+request.getAttribute("message").toString());
		request.getRequestDispatcher("message.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
