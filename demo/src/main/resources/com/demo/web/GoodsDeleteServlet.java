package com.demo.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.demo.base.*;
import com.demo.dao.*;
import com.demo.factory.DAOFactory;
import com.demo.util.*;

import net.sf.json.JSONObject;

import com.demo.model.*;
import com.demo.dao.impl.*;
/**
 * Servlet implementation class GoodsDeleteServlet
 */
public class GoodsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DBUtils dbUtil =new DBUtils();  
    GoodsDaoImpl goodsDao = DAOFactory.getGoodsDaoInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String delId=request.getParameter("id");
		Connection con=null;
		try {
			con=dbUtil.createConn();
			JSONObject result=new JSONObject();
			int delNums=goodsDao.delete(con, delId);
			if(delNums==1){
				result.put("success", "true");
			}else{
				result.put("errorMsg", "删除失败！");
			}
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dbUtil.close(con);
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
