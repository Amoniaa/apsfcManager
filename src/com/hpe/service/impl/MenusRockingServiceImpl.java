/**
 * 
 */
package com.hpe.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.hpe.dao.IMenusRockingDao;
import com.hpe.dao.impl.MenusRockingDaoImpl;
import com.hpe.pojo.MenusRocking;
import com.hpe.service.IMenusRockingService;

/** 
 * 类描述：
 * 作者：wanghongyuan
 * 创建日期：2019年9月6日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public class MenusRockingServiceImpl implements IMenusRockingService {
	
	private IMenusRockingDao menusRockingDao=new MenusRockingDaoImpl();
	
	@Override
	public List<MenusRocking> getRocking() {
	List<MenusRocking> list=menusRockingDao.getAll();		
	Collections.sort(list, new Comparator<MenusRocking>() {
		public int compare(MenusRocking o1, MenusRocking o2) {
			int i = Integer.valueOf(o2.getSums1())-Integer.valueOf(o1.getSums1());
	        	return i;
	        }
	});
		return list;
	}
	
}
