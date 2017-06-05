package com.demo.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.dao.impl.GoodsDaoImpl;
import com.demo.factory.DAOFactory;
import com.demo.model.PageBean;
import com.demo.util.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class GoodsListServlet
 */
public class GoodsListServlet extends HttpServlet {
//	public static String driver;//定义驱动
//	public static String url;//定义链接URL
//
//	public static String username;//定义数据库用户名
//	public static String password;//定义数据库密码
//	public static Connection con;//定义链接
//	//设置connection
//	static{
//	driver="com.mysql.jdbc.Driver";
//	url="jdbc:mysql://localhost:3306/demo";
//	username="root";
//	password="0000";
//	try {
//	Class.forName(driver);
//	con=DriverManager.getConnection(url,username,password);
//	if(con!=null){System.out.println("链接成功--------------------------------");}
//	} catch (ClassNotFoundException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//	}catch(SQLException ex){
//	ex.printStackTrace();
//	}
//	}
private static final long serialVersionUID = 1L;
	DBUtils dbUtils=new DBUtils();
	GoodsDaoImpl goodsDao=DAOFactory.getGoodsDaoInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page=request.getParameter("page");
		String rows=request.getParameter("rows");
		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Connection con=null;
		con=dbUtils.createConn2();
		try{
			System.out.println("connection succses");
			JSONObject result=new JSONObject();
			JSONArray jsonArray=JsonUtil.formatRsToJsonArray(goodsDao.list(con, pageBean));
			System.out.println(jsonArray);
			int total=goodsDao.count(con);
			System.out.println(total);
			result.put("rows",jsonArray);
			result.put("total",total);
			System.out.println(result);
			ResponseUtil.write(response,result);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
