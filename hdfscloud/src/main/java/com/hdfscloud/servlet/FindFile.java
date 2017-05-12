package com.hdfscloud.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hdfscloud.model.File;
import com.hdfscloud.util.showFile;


/**
 * Servlet implementation class FindFile
 */
public class FindFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindFile() {
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
		String username=null;
		if (request.getSession().getAttribute("username")==null){response.sendRedirect("fileLogin.jsp");}
		else{ username= (String)request.getSession().getAttribute("username");
		//PrintWriter out = response.getWriter();
		int pageSize=12;
		int pageNow=1;//默认显示第一页
		int rowCount=0;//
		int pageCount=1;//该值是通过pageSize和rowCount
//		//接受用户希望显示的页数（pageNow）
		String s_dirname=(String) request.getAttribute("dirname");
		String s_pageNow=request.getParameter("pageNow");
		if(request.getParameter("dirname")!=null){ s_dirname=request.getParameter("dirname");}
		System.out.println("FindFile s_dirname: "+s_dirname);
		String dirname=null;
		if (request.getParameter("username")!=null){username=request.getParameter("username").toString();}
		if (request.getAttribute("username")!=null){username=request.getAttribute("username").toString();}
		System.out.println("username:!! "+username);
		if (username.equals("yanbin")){
			System.out.println("welcome yanbin!,you have the highest privilage");
		dirname = "/";}
		else{
		dirname = "/hadoop";
		System.out.println("welcome not yanbin!,you don't have the highest privilage");
		}
		if(s_dirname!=(null)){
			//接收到了pageNow
			dirname=s_dirname;
			}
		if(s_pageNow!=null){
		//接收到了pageNow
		pageNow=Integer.parseInt(s_pageNow);
		}
		showFile showfile=new showFile();
		ArrayList<File> list=null;
		System.out.println(dirname);
		try {
			list = showfile.show(dirname);
			rowCount = list.size();
			System.out.println("FindFile dirname:!! "+dirname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if((rowCount%pageSize==0)&&(rowCount!=0)){
		pageCount=rowCount/pageSize;
		}else{
		pageCount=rowCount/pageSize+1;
		}
		System.out.println(list);
		int pageStart=(pageNow-1)*pageSize;
		int pageEnd=(pageStart+pageSize)<rowCount?pageStart+pageSize:rowCount;
		List<File> tmpList=list.subList(pageStart, pageEnd);
		request.setAttribute("pageNow", pageNow);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("list", tmpList);
		request.setAttribute("dirname", dirname);
		request.getRequestDispatcher("FileTree.jsp").forward(request, response);
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}
}
