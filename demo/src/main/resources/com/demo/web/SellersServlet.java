package com.demo.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.dao.impl.SellersDaoImpl;
import com.demo.factory.DAOFactory;
import com.demo.model.PageBean;
import com.demo.model.Sellers;
import com.demo.util.DBUtils;
import com.demo.util.JsonUtil;
import com.demo.util.ResponseUtil;
import com.demo.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SellersServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	DBUtils dbUtil = new DBUtils();
	SellersDaoImpl sellersDao = DAOFactory.getSellersDaoInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SellersServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		if (StringUtil.isNotEmpty(type)) {
			if (type.equals("idlist")) {
				idList(request, response);
			}
			if (type.equals("idsearch")) {
				idSearch(request, response);
			}
			if (type.equals("list")) {
				list(request, response);
			}
			if (type.equals("save")) {
					save(request, response);
			}
			if (type.equals("delete")) {
				delete(request, response);
			}
		} else {
			System.out.println("type is null!:null= "+type);
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

	protected void idList(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		con = dbUtil.createConn2();
		try {
			System.out.println("connection succses");
			JSONObject result = new JSONObject();
			JSONArray jsonArray = JsonUtil.formatRsToJsonArray(sellersDao.idList(con));
			System.out.println(jsonArray);
			System.out.println(result);
			// response.setHeader("Access-Control-Allow-Origin", "*");
			ResponseUtil.write(response, jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	protected void idSearch(HttpServletRequest request, HttpServletResponse response) {
		int searchid=Integer.parseInt(request.getParameter("searchid"));
		Connection con = null;
		con = dbUtil.createConn2();
		try {
			System.out.println("connection succses");
			JSONObject result = new JSONObject();
			JSONArray jsonArray = JsonUtil.formatRsToJsonArray(sellersDao.idSearch(con, searchid));
			System.out.println(jsonArray);
			int total = sellersDao.count(con);
			System.out.println(total);
			result.put("rows", jsonArray);
			result.put("total", total);
			System.out.println(result);
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	protected void list(HttpServletRequest request, HttpServletResponse response) {
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Connection con = null;
		con = dbUtil.createConn2();
		try {
			System.out.println("connection succses");
			JSONObject result = new JSONObject();
			JSONArray jsonArray = JsonUtil.formatRsToJsonArray(sellersDao.list(con, pageBean));
			System.out.println(jsonArray);
			int total = sellersDao.count(con);
			System.out.println(total);
			result.put("rows", jsonArray);
			result.put("total", total);
			System.out.println(result);
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	protected void save(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String name = request.getParameter("seller_name");
		String permit = request.getParameter("seller_permit");
		String code=request.getParameter("seller_code");
		String address=request.getParameter("seller_address");
		String phone=request.getParameter("seller_phone");
		String mail=request.getParameter("seller_mail");
		String contact=request.getParameter("seller_contact");
		String other=request.getParameter("seller_other");
		Sellers sellers = new Sellers(name, permit,code,address,phone,mail,contact,other);
		if (StringUtil.isNotEmpty(id)) {
			sellers.setId(Integer.parseInt(id));
		}
		Connection con = null;
		try {
			int saveNums = 0;
			con = dbUtil.createConn();
			JSONObject result = new JSONObject();
			if (StringUtil.isNotEmpty(id)) {
				saveNums = sellersDao.modify(con, sellers);
			} else {
				saveNums = sellersDao.add(con, sellers);
			}
			if (saveNums == 1) {
				result.put("success", "true");
			} else {
				result.put("success", "true");
				result.put("errorMsg", "保存失败");
			}
			result.put("data", sellers);
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dbUtil.close(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
protected void delete(HttpServletRequest request,HttpServletResponse response){
	String delId=request.getParameter("id");
	Connection con=null;
	try {
		con=dbUtil.createConn();
		JSONObject result=new JSONObject();
		String[] ids=delId.split(",");
		int delNums=0;
		for (String id:ids){
		delNums+=sellersDao.delete(con, id);
		}
		if(delNums>=1){
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
}

