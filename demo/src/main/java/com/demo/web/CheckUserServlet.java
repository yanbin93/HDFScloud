package com.demo.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.demo.util.DBUtils;
import com.demo.util.MD5;
import com.demo.util.StringUtil;

/**
 * Servlet implementation class CheckUserServlet
 */
public class CheckUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DBUtils dbUtil = new DBUtils();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		if (StringUtil.isNotEmpty(type)) {
			if (type.equals("companyUser")) {
				try {
					companyUserCheck(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (type.equals("commonUser")) {
				try {
					commonUserCheck(request, response);
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void companyUserCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		MD5 md = new MD5();
		password =md.EncryptionStr32(password, "MD5", "UTF-8");
		if (StringUtil.isEmpty(username) | StringUtil.isEmpty(password)) {
			response.sendRedirect("companyLogin.html");
		}
		Connection con = null;
		boolean flag = false;
		try {
			con = dbUtil.createConn2();
			String sql = "select * from user2 where username=? and password=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet result = pstmt.executeQuery();
			if (result.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag) {
			session.setAttribute("username", username);
			request.getRequestDispatcher("Home.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("companyLogin.html").forward(request, response);
		}
	}

	private void commonUserCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		MD5 md = new MD5();
		password =md.EncryptionStr32(password, "MD5", "UTF-8");
		if (StringUtil.isEmpty(username) | StringUtil.isEmpty(password)) {
			response.sendRedirect("login.jsp");
		}
		Connection con = null;
		boolean flag = false;
		try {
			con = dbUtil.createConn2();
			String sql = "select * from user where username=? and password=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet result = pstmt.executeQuery();
			if (result.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag) {
			session.setAttribute("username", username);
			request.getRequestDispatcher("trace.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
