package com.demo.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.dao.impl.*;
import com.demo.factory.DAOFactory;
import com.demo.model.PageBean;
import com.demo.model.Products;
import com.demo.util.DBUtils;
import com.demo.util.JDBCToHiveUtils;
import com.demo.util.JsonUtil;
import com.demo.util.ListUtil;
import com.demo.util.ResponseUtil;
import com.demo.util.RsToStringUtil;
import com.demo.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class ProductsListServlet
 */
public class ProductsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DBUtils dbUtil = new DBUtils();
	ProductsDaoImpl productsDao = DAOFactory.getProductsDaoInstance();
	ManufacturersDaoImpl manufacturersDao = DAOFactory.getManufacturersDaoInstance();
	SellersDaoImpl sellersDao = DAOFactory.getSellersDaoInstance();
	SuppliersDaoImpl suppliersDao = DAOFactory.getSuppliersDaoInstance();
	GoodsDaoImpl goodsDao = DAOFactory.getGoodsDaoInstance();
	Records_checkDaoImpl records_checkDao= DAOFactory.getRecords_checkDaoInstance();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductsListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @throws UnsupportedEncodingException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		if (StringUtil.isNotEmpty(type)) {
			if (type.equals("idlist")) {
				idList(request, response);
			}
			if (type.equals("goodsidsearch")){
				try {
					goodsidSearch2(request,response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (type.equals("idsearch")) {
				idSearch(request, response);
			}
			if (type.equals("idsearchString")) {
				idSearch(request, response);
			}
			if (type.equals("namesearch")) {
				nameSearch(request, response);
			}
			if (type.equals("list")) {
				list(request, response);
			}
			if (type.equals("save")) {
				try {
					save(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
			JSONArray jsonArray = JsonUtil.formatRsToJsonArray(productsDao.idList(con));
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
	protected void goodsidSearch(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String goodscode = request.getParameter("goodscode");
		System.out.println("????");
		if (StringUtil.isEmpty(goodscode)){return;} 
		ResultSet rs;
		rs = goodsDao.goodsidSearch(JDBCToHiveUtils.getConnnection(),goodscode);
		int pdtid=0;
		boolean flag=false;
		while(rs.next()){
			pdtid=rs.getInt("productid");
			flag=true;
		}
		if (!flag){
			System.out.print("what??");
			JSONObject result = new JSONObject();
			JSONObject data=new JSONObject();
			data.put("id", "没有数据");
			result.put("rows",data);
			result.put("total",1);
			ResponseUtil.write(response, result);
			return;
		}else{
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		int searchid=pdtid;
		System.out.println("searchid:  "+searchid);
		Connection con = null;
		con = dbUtil.createConn2();
		try {
//			System.out.println("connection succses");
//			JSONObject result = new JSONObject();
//			JSONArray jsonArray = JsonUtil.formatRsToJsonArray(productsDao.idSearch(con,searchid));
//			System.out.println(jsonArray);
//			int total = 1;
//			System.out.println(total);
//			result.put("rows", jsonArray);
//			result.put("total", total);
//			System.out.println(result);
//			ResponseUtil.write(response, result);
			System.out.println("connection succses");
			ResultSet rs1 = productsDao.idSearch(con,searchid);
			int manufacturerid=0;
			int sellerid = 0;
			int supplierid = 0 ;
			while(rs1.next()){
				manufacturerid=rs1.getInt("manufacturer_id");
				sellerid = rs1.getInt("seller_id");
				supplierid = rs1.getInt("supplier_id");
			}
			
			String string = RsToStringUtil.formatRsToString(rs1);
			String string1 = RsToStringUtil.formatRsToString(manufacturersDao.idSearch(con, manufacturerid));
			String string2 = RsToStringUtil.formatRsToString(sellersDao.idSearch(con, sellerid));
			String string3 = RsToStringUtil.formatRsToString(suppliersDao.idSearch(con, supplierid));
			string += string1+string2+string3;
			System.out.println(string);
			ResponseUtil.write(response, string);
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
	}
	
	protected void goodsidSearch2(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String goodscode = request.getParameter("goodscode");
		System.out.println("????");
		if (StringUtil.isEmpty(goodscode)){return;} 
		ResultSet rs;
		rs = goodsDao.goodsidSearch(JDBCToHiveUtils.getConnnection(),goodscode);
		int pdtid=0;
		boolean flag=false;
		while(rs.next()){
			pdtid=rs.getInt("productid");
			flag=true;
		}
		if (!flag){
			System.out.print("what??");
			List<String> string = null;
			request.setAttribute("list", string);
		}else{
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		int searchid=pdtid;
		System.out.println("searchid:  "+searchid);
		Connection con = null;
		con = dbUtil.createConn2();
		try {
//			System.out.println("connection succses");
//			JSONObject result = new JSONObject();
//			JSONArray jsonArray = JsonUtil.formatRsToJsonArray(productsDao.idSearch(con,searchid));
//			System.out.println(jsonArray);
//			int total = 1;
//			System.out.println(total);
//			result.put("rows", jsonArray);
//			result.put("total", total);
//			System.out.println(result);
//			ResponseUtil.write(response, result);
			System.out.println("connection succses");
			ResultSet rs1 = productsDao.idSearch(con,searchid);
			int manufacturerid=0;
			int sellerid = 0;
			int supplierid = 0 ;
			while(rs1.next()){
				manufacturerid=rs1.getInt("manufacturer_id");
				sellerid = rs1.getInt("seller_id");
				supplierid = rs1.getInt("supplier_id");
			}
			
			List<String> string = ListUtil.formatRsToList(productsDao.idSearch(con,searchid));
			List<String> string1 = ListUtil.formatRsToList(manufacturersDao.idSearch(con, manufacturerid));
			List<String> string2 = ListUtil.formatRsToList(sellersDao.idSearch(con, sellerid));
			List<String> string3 = ListUtil.formatRsToList(suppliersDao.idSearch(con, supplierid));
			List<String> string4 = ListUtil.formatRsToList(records_checkDao.idSearch(con, searchid));
			string.addAll(string1);
			string.addAll(string2);
			string.addAll(string3);
			string.addAll(string4);
			System.out.println(string.size()+"  :  "+string.toString());
			request.setAttribute("list", string);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		}
		request.getRequestDispatcher("trace.jsp").forward(request,response) ;
	}
	protected void idSearch(HttpServletRequest request, HttpServletResponse response) {
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		int searchid=Integer.parseInt(request.getParameter("searchid"));
		System.out.println("searchid:  "+searchid);
		Connection con = null;
		con = dbUtil.createConn2();
		try {
			System.out.println("connection succses");
			JSONObject result = new JSONObject();
			JSONArray jsonArray = JsonUtil.formatRsToJsonArray(productsDao.idSearch(con,searchid));
			System.out.println(jsonArray);
			int total = 1;
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
	protected void idSearchString(HttpServletRequest request, HttpServletResponse response) {
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		int searchid=Integer.parseInt(request.getParameter("searchid"));
		System.out.println("searchid:  "+searchid);
		Connection con = null;
		con = dbUtil.createConn2();
		try {
			System.out.println("connection succses");
			JSONObject result = new JSONObject();
			String string = RsToStringUtil.formatRsToString(productsDao.idSearch(con,searchid));
			System.out.println(string);
			ResponseUtil.write(response, string);
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
	protected void nameSearch(HttpServletRequest request, HttpServletResponse response) {
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		String searchname=request.getParameter("searchname");
		System.out.println("searchname:  "+searchname);
		Connection con = null;
		con = dbUtil.createConn2();
		try {
			System.out.println("connection succses");
			JSONObject result = new JSONObject();
			JSONArray jsonArray = JsonUtil.formatRsToJsonArray(productsDao.nameSearch(con,searchname));
			System.out.println(jsonArray);
			int total = 1;
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
			JSONArray jsonArray = JsonUtil.formatRsToJsonArray(productsDao.list(con, pageBean));
			System.out.println(jsonArray);
			int total = productsDao.count(con);
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

	protected void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String name = request.getParameter("products_name");
		String other = request.getParameter("products_other");
		int manufacturer_id = Integer.parseInt(request.getParameter("manufacturer_id"));
		int seller_id = Integer.parseInt(request.getParameter("seller_id"));
		int supplier_id = Integer.parseInt(request.getParameter("supplier_id"));

		Products products = new Products(name, other, manufacturer_id, seller_id, supplier_id);
		if (StringUtil.isNotEmpty(id)) {
			products.setId(Integer.parseInt(id));
		}
		Connection con = null;
		try {
			int saveNums = 0;
			con = dbUtil.createConn();
			JSONObject result = new JSONObject();
			if (StringUtil.isNotEmpty(id)) {
				saveNums = productsDao.modify(con, products);
			} else {
				saveNums = productsDao.add(con, products);
			}
			if (saveNums == 1) {
				result.put("success", "true");
			} else {
				result.put("success", "true");
				result.put("errorMsg", "保存失败");
			}
			result.put("data", products);
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
		delNums+=productsDao.delete(con, id);
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
