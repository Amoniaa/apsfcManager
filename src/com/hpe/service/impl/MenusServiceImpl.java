/**
 * 
 */
package com.hpe.service.impl;

import com.hpe.dao.IMenusDao;
import com.hpe.dao.impl.MenusDaoImpl;
import com.hpe.pojo.Menus;
import com.hpe.pojo.MenusInfo;
import com.hpe.service.IMenusService;
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
public class MenusServiceImpl implements IMenusService {
	
	private IMenusDao menusDao=new MenusDaoImpl();
	@Override
	public Page getMenus(Page page) {
		return menusDao.getMenus(page);
	}
	
	@Override
	public int addMenus(Menus menus) {
		//根据用户名查询
		Menus menus1=menusDao.getMenusByName(menus.getName());
		if(menus1!=null){
			return -1;
		}
		return menusDao.addMenus(menus);
	}

	@Override
	public Menus getMenusById(int id) {
		return menusDao.getMenusById(id);
	}

	@Override
	public MenusInfo getMenusInfoById(int id) {
		return menusDao.getMenusInfoById(id);
	}

	@Override
	public int update(Menus menu) {
		
		return menusDao.update(menu);
	}

	@Override
	public int delete(int id) {
		
		return menusDao.delete(id);
	}

	@Override
	public Page searchMenu(Page page, String menuname) {
		// TODO Auto-generated method stub
		return menusDao.searchMenu(page, menuname);
	}

}
