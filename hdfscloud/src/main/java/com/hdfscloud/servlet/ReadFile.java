package com.hdfscloud.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ReadFile
 */
public class ReadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("utf-8"); 
		PrintWriter out = response.getWriter();
		com.hdfscloud.util.showFile showfile=new com.hdfscloud.util.showFile();
		String s_filename=request.getParameter("filename");
		String content =null;
		String filename=null;
		if(s_filename!=null){
			//接收到了pageNow
			filename=s_filename;
			}
		if (filename!=null){
		try {
			content = showfile.showFile(filename);
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		out.println(content);
		request.setAttribute("content", content);
		request.getRequestDispatcher("ReadFile.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
