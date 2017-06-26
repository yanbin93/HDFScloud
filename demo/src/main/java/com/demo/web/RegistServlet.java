package com.demo.web;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.util.DBUtils;
import com.demo.util.GetProperties;
import com.demo.util.JDBCToHiveUtils;
import com.demo.util.MD5;
import com.demo.util.StringUtil;

public class RegistServlet extends HttpServlet {
	private static String usernameTable=null;
	DBUtils dbUtil = new DBUtils();
	/**
	 * Constructor of the object.
	 */
	public RegistServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		if (StringUtil.isNotEmpty(type)) {
			if (type.equals("companyUser")) {
				try {
					companyUserRegist(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (type.equals("commonUser")) {
				try {
					commonUserRegist(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				System.out.println("nothing");
			}
		}

	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
	public void companyUserRegist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("utf-8"); 
		PrintWriter out= response.getWriter();
		//DBconn conn=new DBconn();
		Connection con =dbUtil.createConn2();
		MD5 md=new MD5();
		String username=request.getParameter("usernamesignup");
		String pwd=request.getParameter("passwordsignup");
		String email=request.getParameter("emailsignup");
		//String other=request.getParameter("othersignin");
		pwd =md.EncryptionStr32(pwd, "MD5", "UTF-8");
		String sql="insert into  user2 values ("+null+",?,?,?)";
		java.sql.PreparedStatement ps;
		int rs;
		boolean flag = false;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(2,pwd);
			// ps.setString(3,int);
			ps.setString(3,email);
			rs = ps.executeUpdate();
			flag = true;
			if (rs>0){
			System.out.println("添加用户成功");
			}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		String type=(String)request.getParameter("type");	
		request.setAttribute("type",type);
			if(flag){
				request.setAttribute("message","注册成功！");
				request.getRequestDispatcher("message.jsp").forward(request, response);
			}else{
				request.setAttribute("message","注册失败！");
				request.getRequestDispatcher("message.jsp").forward(request, response);
			}
	}
	public void commonUserRegist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("utf-8"); 
		PrintWriter out= response.getWriter();
		//DBconn conn=new DBconn();
		Connection con =dbUtil.createConn2();
		if (con!=null){
			System.out.println("==================");
			System.out.println("数据库连接成功！");
			System.out.println("==================");
		}else{
			System.out.println("==================");
			System.out.println("数据库连接失败！");
			System.out.println("==================");
		}
		MD5 md=new MD5();
		String username=request.getParameter("usernamesignup");
		String pwd=request.getParameter("passwordsignup");
		String email=request.getParameter("emailsignup");
		//String other=request.getParameter("othersignin");
		pwd =md.EncryptionStr32(pwd, "MD5", "UTF-8");
		String sql="insert into  user values ("+null+",?,?,?)";
		java.sql.PreparedStatement ps;
		int rs;
		boolean flag = false;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(2,pwd);
			// ps.setString(3,int);
			ps.setString(3,email);
			rs = ps.executeUpdate();
			flag = true;
			if (rs>0){
			System.out.println("添加用户成功");
			}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		String type=(String)request.getParameter("type");	
		request.setAttribute("type",type);
			if(flag){
				request.setAttribute("message","注册成功！");
				request.getRequestDispatcher("message.jsp").forward(request, response);
			}else{
				request.setAttribute("message","注册失败！");
				request.getRequestDispatcher("message.jsp").forward(request, response);
			}
	}
}
