/**
 * 
 */
package com.hpe.dao.impl;


import java.sql.Connection;
import java.util.ArrayList;

import com.hpe.dao.IMenusDao;
import com.hpe.pojo.Menus;
import com.hpe.pojo.MenusInfo;
import com.hpe.util.DBUtil;
import com.hpe.util.Page;

/** 
 * 类描述：
 * 作者：wanghongyuan
 * 创建日期：2019年9月4日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public class MenusDaoImpl implements IMenusDao {

	private DBUtil dbutil=new DBUtil();
	@Override
	public Page getMenus(Page page) {
		String sql="SELECT menus.id AS id,menus.name,imgpath,burden,types.name AS typename,"
				+ "brief,price,sums,price1,sums1 FROM menus INNER JOIN types "
				+ "ON types.id=typeid";
		Page page1=null;
		page1=dbutil.getQueryPage(MenusInfo.class, sql, null, page);
		return page1;
	}

	@Override
	public int addMenus(Menus menus) {
		String sql="insert into menus(name,burden,price,price1,brief,typeid,imgpath) values(?,?,?,?,?,?,?)";
		Object[] param={menus.getName(),menus.getBurden(),menus.getPrice(),menus.getPrice1(),menus.getBrief(),menus.getTypeid(),menus.getImgpath()};
		int result=0;
		try {
			result = dbutil.execute(sql, param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Menus getMenusByName(String name) {
		String sql="select * from menus where name=?";
		Object[] param={name};
		Menus menus=null;
		//执行描述
		try {
			menus = (Menus) dbutil.getObject(Menus.class, sql, param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//返回查询结果
		return menus;
	}

	@Override
	public Menus getMenusById(int id) {
		String sql="select * from menus where id=?";
		Object[] param={id};
		Menus menus=null;
		//执行描述
		try {
			menus = (Menus) dbutil.getObject(Menus.class, sql, param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//返回查询结果
		return menus;
	}

	@Override
	public MenusInfo getMenusInfoById(int id) {
		String sql="SELECT menus.id AS id,menus.name,imgpath,burden,types.name AS typename,"
				+ "brief,price,sums,price1,sums1 FROM menus INNER JOIN types "
				+ "ON types.id=typeid where menus.id=?";
		Object[] param={id };
		MenusInfo menus=null;
		//执行描述
		try {
			menus = (MenusInfo) dbutil.getObject(MenusInfo.class, sql, param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//返回查询结果
		return menus;
	}

	@Override
	public int update(Menus menu) {
		
		String sql = "UPDATE menus SET name = ?,burden = ?,price = ?,price1 = ?,brief = ?,typeid = ?,imgpath = ? WHERE id = ?";
		Object[] param = {menu.getName(), menu.getBurden(),menu.getPrice(),menu.getPrice1(),menu.getBrief(),menu.getTypeid(),menu.getImgpath(),menu.getId()};
		int result = 0;
		try {
			result = dbutil.execute(sql, param);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(int id) {
		
		String sql = "DELETE FROM menus WHERE id = ?";
		Object[] param = {id};
		int result = 0;
		try {
			result = dbutil.execute(sql, param);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public Menus getMenusById(int id, Connection conn) {
		String sql = "select * from menus where id=?";
		Object[] param = {id };
		Menus menus = null;
		//执行查询
		try {
			menus = (Menus) dbutil.getObject(conn, Menus.class, sql, param);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menus;
	}

	@Override
	public Page searchMenu(Page page, String menuname) {
		String sql="SELECT menus.id AS id,menus.name,imgpath,burden,types.name AS typename,"
				+ "brief,price,sums,price1,sums1 FROM menus INNER JOIN types "
				+ "ON types.id=typeid WHERE menus.name LIKE ?";
		Object[] param = {("%" + menuname + "%") }; 
		Page page1 = null;
		page1=dbutil.getQueryPage(MenusInfo.class, sql, param, page);
		return page1;
	}
}
