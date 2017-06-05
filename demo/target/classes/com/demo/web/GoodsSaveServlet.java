package com.demo.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.dao.UserDao;
import com.demo.factory.DAOFactory;
import com.demo.model.*;
import com.demo.util.DBUtils;
import com.demo.util.DbUtil;
import com.demo.util.ResponseUtil;
import com.demo.util.StringUtil;
import com.demo.dao.*;
import com.demo.dao.impl.*;
import com.demo.factory.*;
import net.sf.json.JSONObject;

public class GoodsSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DBUtils dbUtil=new DBUtils();
	GoodsDaoImpl goodsDao=DAOFactory.getGoodsDaoInstance();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("goods_name");
		String code=request.getParameter("goods_code");
		String other=request.getParameter("goods_other");
		String products_id=request.getParameter("products_id");
		String id=request.getParameter("id");
		
		Goods goods=new Goods(name, code, other,Integer.parseInt(products_id));
		if(StringUtil.isNotEmpty(id)){
			goods.setId(Integer.parseInt(id));
		}
		
		Connection con=null;
		try {
			int saveNums=0;
			con=dbUtil.createConn();
			JSONObject result=new JSONObject();
			if(StringUtil.isNotEmpty(id)){
				saveNums=goodsDao.modify(con, goods);
			}else{
				saveNums=goodsDao.add(con, goods);
			}
			if(saveNums==1){
				result.put("success", "true");
			}else{
				result.put("success", "true");
				result.put("errorMsg", "保存失败");
			}
			result.put("data", goods);
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

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	
}

