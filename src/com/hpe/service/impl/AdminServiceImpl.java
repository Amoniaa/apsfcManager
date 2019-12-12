/**
 * 
 */
package com.hpe.service.impl;

import com.hpe.dao.IAdminDao;
import com.hpe.dao.impl.AdminDaoImpl;
import com.hpe.pojo.Admin;
import com.hpe.service.IAdminService;

/** 
 * 类描述：
 * 作者：wanghongyuan
 * 创建日期：2019年9月2日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public class AdminServiceImpl implements IAdminService{

	private IAdminDao adminDao=new AdminDaoImpl();//多态
	@Override
	public Admin login(String name, String pwd) {
		
		return adminDao.login(name, pwd);
	}

	@Override
	public int updateAdmin(Admin admin) {
		//根据用户名查询
		Admin admin1=adminDao.getAdminByName(admin.getName());
		if(admin1!=null && (admin1.getName().equals(admin.getName())) && (admin.getId()!=admin1.getId())){
			return -1;
		}
		return adminDao.updateAdmin(admin);
	}

}
