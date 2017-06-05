package com.demo.base;

import java.sql.Connection;
import java.sql.ResultSet;
import com.demo.model.PageBean;

public interface MyBaseDao<Entity> {
	public ResultSet list(Connection con, PageBean pageBean) throws Exception;

	public int count(Connection con) throws Exception;

	public int delete(Connection con, String id) throws Exception;

	public int add(Connection con, Entity obj) throws Exception;

	public int modify(Connection con, Entity obj) throws Exception;
}
