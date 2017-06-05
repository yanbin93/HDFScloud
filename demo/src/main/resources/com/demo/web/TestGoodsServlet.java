package com.demo.web;
	import java.io.IOException;
	import java.io.UnsupportedEncodingException;
	import java.sql.Connection;
	import java.sql.ResultSet;
	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import com.demo.dao.impl.*;
	import com.demo.factory.DAOFactory;
	import com.demo.model.PageBean;
import com.demo.model.TestGoods;
	import com.demo.util.JDBCToHiveUtils;
	import com.demo.util.JsonUtil;
	import com.demo.util.ResponseUtil;
	import com.demo.util.StringUtil;

	import net.sf.json.JSONArray;
	import net.sf.json.JSONObject;

	/**
	 * Servlet implementation class ProductsListServlet
	 */
	public class TestGoodsServlet extends HttpServlet{
		private static final long serialVersionUID = 1L;
		JDBCToHiveUtils dbUtil = new JDBCToHiveUtils();
		TestGoodsDaoImpl testGoodsDao = DAOFactory.getTestGoodsDaoInstance();
		/**
		 * @see HttpServlet#HttpServlet()
		 */
		public TestGoodsServlet() {
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
						goodsidSearch(request,response);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (type.equals("idsearch")) {
					idSearch(request, response);
				}
				if (type.equals("var")) {
					var(request, response);
				}
				if (type.equals("topnlist")) {
					topnList(request, response);
				}
				if (type.equals("topn")) {
					topN(request, response);
				}
				if (type.equals("avg")) {
					avg(request, response);
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
			con = dbUtil.getConnnection();
			try {
				System.out.println("connection succses");
				JSONObject result = new JSONObject();
				JSONArray jsonArray = JsonUtil.formatRsToJsonArray(testGoodsDao.idList(con));
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
			rs = testGoodsDao.goodsidSearch(dbUtil.getConnnection(),goodscode);
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
			con = dbUtil.getConnnection();
			try {
				System.out.println("connection succses");
				JSONObject result = new JSONObject();
				JSONArray jsonArray = JsonUtil.formatRsToJsonArray(testGoodsDao.idSearch(con, searchid));
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
		}
		protected void idSearch(HttpServletRequest request, HttpServletResponse response) {
			String page = request.getParameter("page");
			String rows = request.getParameter("rows");
			int searchid=Integer.parseInt(request.getParameter("searchid"));
			System.out.println("searchid:  "+searchid);
			Connection con = null;
			con = dbUtil.getConnnection();
			try {
				System.out.println("connection succses");
				JSONObject result = new JSONObject();
				JSONArray jsonArray = JsonUtil.formatRsToJsonArray(testGoodsDao.idSearch(con, searchid));
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

		protected void nameSearch(HttpServletRequest request, HttpServletResponse response) {
			String page = request.getParameter("page");
			String rows = request.getParameter("rows");
			String searchname=request.getParameter("searchname");
			System.out.println("searchname:  "+searchname);
			Connection con = null;
			con = dbUtil.getConnnection();
			try {
				System.out.println("connection succses");
				JSONObject result = new JSONObject();
				JSONArray jsonArray = JsonUtil.formatRsToJsonArray(testGoodsDao.nameSearch(con,searchname));
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
		protected void topN(HttpServletRequest request, HttpServletResponse response) {
			String page = request.getParameter("page");
			String rows = request.getParameter("rows");
			String n=request.getParameter("n");
			System.out.println("topn:  "+n);
			Connection con = null;
			con = dbUtil.getConnnection();
			try {
				System.out.println("connection succses");
				JSONObject result = new JSONObject();
				//String sql = "from (select productid as productid,count(productid) as total from product group by productid order by total desc limit "+n+
						// ")as a,product select product.id as id,product.productname as productname,product.productcode as porductcode,a.productid as productid,a.total where a.productid=product.productid ";
				String sql = "select cast(productid as string) as text,count(productid) as size from product group by productid order by size  desc limit "+n;
				JSONArray jsonArray = JsonUtil.formatRsToJsonArray(testGoodsDao.query(con, sql));
				System.out.println(jsonArray);
				int total = 1;
				System.out.println(total);
				result.put("result", jsonArray);
				//result.put("total", total);
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
		protected void topnList(HttpServletRequest request, HttpServletResponse response) {
			String page = request.getParameter("page");
			String rows = request.getParameter("rows");
			String n=request.getParameter("n");
			System.out.println("topn:  "+n);
			Connection con = null;
			con = dbUtil.getConnnection();
			try {
				System.out.println("connection succses");
				JSONObject result = new JSONObject();
				String sql = "from (select productid as productid,count(productid) as total from product group by productid order by total desc limit "+n+
						 ")as a,product select product.id as id,product.productname as productname,product.productcode as porductcode,a.productid as productid,a.total where a.productid=product.productid ";
				//String sql = "select cast(productid as string) as text,count(productid) as size from product group by productid order by size  desc limit "+n;
				JSONArray jsonArray = JsonUtil.formatRsToJsonArray(testGoodsDao.query(con, sql));
				System.out.println(jsonArray);
				int total = 1;
				String sql2 = "from (select productid as productid,count(productid) as total from product group by productid order by total desc limit "+n+
						 ")as a,product select count(*) as totalal where a.productid=product.productid";
				ResultSet rs = testGoodsDao.query(con, sql2);
				if(rs.next()){
					total=rs.getInt("totalal");
				}else{
					total=0;
				}
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
		protected void avg(HttpServletRequest request, HttpServletResponse response) {
			String page = request.getParameter("page");
			String rows = request.getParameter("rows");
			String n=request.getParameter("n");
			System.out.println("topn:  "+n);
			Connection con = null;
			con = dbUtil.getConnnection();
			try {
				System.out.println("connection succses");
				JSONObject result = new JSONObject();
				//String sql = "from (select productid as productid,count(productid) as total from yanbin.product group by productid) as a select avg(total) as average";
				String sql = "from (select productid as productid,count(productid) as total from yanbin.product group by productid) as a select avg(total) as average";
				JSONArray jsonArray = JsonUtil.formatRsToJsonArray(testGoodsDao.query(con, sql));
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
		protected void var(HttpServletRequest request, HttpServletResponse response) {
			String page = request.getParameter("page");
			String rows = request.getParameter("rows");
			String n=request.getParameter("n");
			Connection con = null;
			con = dbUtil.getConnnection();
			try {
				System.out.println("connection succses");
				JSONObject result = new JSONObject();
				//String sql = "from (select productid as productid,count(productid) as total from yanbin.product group by productid) as a select avg(total) as average";
				String sql = "from (select productid as productid,count(productid) as total from yanbin.product group by productid) as a select variance(total) as vari";
				JSONArray jsonArray = JsonUtil.formatRsToJsonArray(testGoodsDao.query(con, sql));
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
			con = dbUtil.getConnnection();
			try {
				System.out.println("connection succses");
				JSONObject result = new JSONObject();
				JSONArray jsonArray = JsonUtil.formatRsToJsonArray(testGoodsDao.list(con, pageBean));
				System.out.println(jsonArray);
//				int total = testGoodsDao.count(con);
				int total = 98462;
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
			int productid = Integer.parseInt(request.getParameter("productid"));
			int productcode = Integer.parseInt(request.getParameter("productcode"));
			String productno = request.getParameter("productno");
			String name = request.getParameter("productname");
			TestGoods testGoods = new TestGoods(productid, productcode, productno, name);
			if (StringUtil.isNotEmpty(id)) {
				testGoods.setId(Integer.parseInt(id));
			}
			Connection con = null;
			try {
				int saveNums = 0;
				con = dbUtil.getConnnection();
				JSONObject result = new JSONObject();
				if (StringUtil.isNotEmpty(id)) {
					saveNums = testGoodsDao.modify(con, testGoods);
				} else {
					saveNums = testGoodsDao.add(con, testGoods);
				}
				if (saveNums == 1) {
					result.put("success", "true");
				} else {
					result.put("success", "true");
					result.put("errorMsg", "保存失败");
				}
				result.put("data", testGoods);
				ResponseUtil.write(response, result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					con.close();;
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
			con=dbUtil.getConnnection();
			JSONObject result=new JSONObject();
			String[] ids=delId.split(",");
			int delNums=0;
			for (String id:ids){
			delNums+=testGoodsDao.delete(con, id);
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
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	}

