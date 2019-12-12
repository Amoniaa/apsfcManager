/**
 * 
 */
package com.hpe.service.impl;

import com.hpe.dao.IUsersDao;
import com.hpe.dao.impl.UsersDaoImpl;
import com.hpe.pojo.Users;
import com.hpe.service.IUsersService;

/** 
 * 类描述：
 * 作者：wanghongyuan
 * 创建日期：2019年9月4日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public class UsersServiceImpl implements IUsersService {

	private IUsersDao usersDao=new UsersDaoImpl();//多态
	
	@Override
	public Users login(String name, String pwd) {
		return usersDao.login(name, pwd);
	}

	@Override
	public int updateUsers(Users user) {
		Users user1=usersDao.getUsersByName(user.getName());
		if(user1!=null && (user1.getName().equals(user.getName())) && (user.getId()!=user1.getId())){
			return -1;
		}
		return usersDao.updateUsers(user);
	}

	@Override
	public int addUsers(Users user) {
		//根据用户名查询
		Users user1=usersDao.getUsersByName(user.getName());
		if(user1!=null){
			return -1;
		}
		return usersDao.addUsers(user);
	}

}
