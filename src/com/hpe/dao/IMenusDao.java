/**
 * 
 */
package com.hpe.dao;


import java.sql.Connection;
import java.util.ArrayList;

import com.hpe.pojo.Menus;
import com.hpe.pojo.MenusInfo;
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
public interface IMenusDao {

	/**
	 * 
	 * 方法描述：分页查询
	 * @param page
	 * @return
	 */
	Page getMenus(Page page);
	
	/**
	 * 
	 * 方法描述：添加
	 * @param menus
	 * @return 影响的行数
	 */
	int addMenus(Menus menus);
	
	/**
	 * 
	 * 方法描述：根据name查询
	 * @param name
	 * @return 菜品信息
	 */
	Menus getMenusByName(String name);
	
	/**
	 * 
	 * 方法描述：根据id查询
	 * @param id
	 * @return 菜品信息
	 */
	Menus getMenusById(int id);
	
	/**
	 * 
	 * 方法描述：根据id查询
	 * @param id
	 * @return 菜品信息
	 */
	MenusInfo getMenusInfoById(int id);
	
	/**
	 * 
	 * 方法描述：修改菜品
	 * @param menu
	 * @return 影响的行数
	 */
	int update(Menus menu);
	
	/**
	 * 
	 * 方法描述：根据id删除
	 * @param id
	 * @return 影响的行数
	 */
	int delete(int id);
	
	/**
	 * 针对事务
	 * 方法描述：根据id查询
	 * @param name
	 * @return 菜品信息
	 */
	Menus getMenusById(int id, Connection conn);

	/**
	 * 
	 * 方法描述：查询菜品
	 * @param page
	 * @param menuname
	 * @return 菜单信息分页查询
	 */
	Page searchMenu(Page page, String menuname);
}
