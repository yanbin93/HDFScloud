package com.hdfscloud.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hdfscloud.util.showFile;


/**
 * Servlet implementation class CreateDirServlet
 */
public class CreateDirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateDirServlet() {
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
		String dirname = "/";
		String s_dirname = request.getParameter("uploadDir");
		String newDir="newDir";
		String s_newDir = request.getParameter("newDir");
		if(s_dirname!=null){
			//接收到了pageNow
			dirname=s_dirname;
			}
		if(s_newDir!=null){
			//接收到了pageNow
			newDir=s_newDir;
			}
		boolean result =  false;
		showFile showfile = new showFile();
		try {
			if (dirname.equals("/")){newDir=dirname+newDir;}
			else{newDir=dirname+"/"+newDir;}
			System.out.println(newDir);
			result = showfile.createDir(newDir);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message","文件夹创建失败！"+e.getMessage());
		}
		if (result){
			request.setAttribute("message","文件夹创建成功！");
		}
		request.setAttribute("dirname",dirname);
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
