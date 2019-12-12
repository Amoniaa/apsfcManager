/**
 * 
 */
package com.hpe.dao.impl;

import java.util.List;

import com.hpe.dao.IMenusRockingDao;
import com.hpe.pojo.MenusRocking;
import com.hpe.util.DBUtil;

/** 
 * 类描述：
 * 作者：wanghongyuan
 * 创建日期：2019年9月6日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public class MenusRockingDaoImpl implements IMenusRockingDao {

	private DBUtil dbutil=new DBUtil();
	
	@Override
	public List<MenusRocking> getAll() {
		String sql="SELECT id,name,sums1 FROM menus";
		List list=null;
		try {
			list = dbutil.getQueryList(MenusRocking.class, sql, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
