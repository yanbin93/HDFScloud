package com.demo.dao.impl;
import com.demo.base.*;
import com.demo.model.*;
import com.demo.dao.*;
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao2{
//public ResultSet findList(Connection con,PageBean pageBean) throws Exception{
//	String sql="select * from t_user limit ?,?";
//	PreparedStatement pstmt=con.prepareStatement(sql);
//	pstmt.setInt(1,pageBean.getStart());
//	pstmt.setInt(2,pageBean.getRows());
//	return pstmt.executeQuery();
//}
//
//public int userCount(Connection con)throws Exception{
//	String sql ="select count(*) as total from t_user";
//	PreparedStatement pstmt=con.prepareStatement(sql);
//	ResultSet rs=pstmt.executeQuery();
//	if(rs.next()){
//		return rs.getInt("total");
//	}else{
//		return 0;
//	}
//}
}
