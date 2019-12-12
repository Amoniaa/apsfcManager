/**
 * 
 */
package com.hpe.dao.impl;

import com.hpe.dao.IUsersDao;
import com.hpe.pojo.Users;
import com.hpe.util.DBUtil;

/** 
 * 类描述：
 * 作者：wanghongyuan
 * 创建日期：2019年9月4日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public class UsersDaoImpl implements IUsersDao{

	private DBUtil dbutil=new DBUtil();
	@Override
	public Users login(String name, String pwd) {
		//SQL语句
		String sql="select * from users where name=? and pwd=?";
		//参数列表
		Object[] param={name,pwd};
		//定义实体类接收数据库返回结果
		Users users=null;
		//执行描述
		try {
			users = (Users) dbutil.getObject(Users.class, sql, param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//返回查询结果
		return users;
	}

	@Override
	public int updateUsers(Users users) {
		String sql="update users set name=?, pwd=?, realname=?, sex=?, age=? ,card=?,address=?, phone=?, email=?, code=? where id=?";
		Object[] param={users.getName(),users.getPwd(),users.getRealname(),users.getSex(),users.getAge(),users.getCard(),users.getAddress(),users.getPhone(),users.getEmail(),users.getCode(),users.getId()};
		int result=0;
		try {
			result = dbutil.execute(sql, param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Users getUsersByName(String name) {
		String sql="select * from users where name=?";
		Object[] param={name};
		Users users=null;
		//执行描述
		try {
			users = (Users) dbutil.getObject(Users.class, sql, param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//返回查询结果
		return users;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
	}

	@Override
	public int addUsers(Users user) {
		String sql="insert into users(name,pwd,realname,sex,age,card,address,phone,email,code,type) values(?,?,?,?,?,?,?,?,?,?,1)";
		Object[] param={user.getName(),user.getPwd(),user.getRealname(),user.getSex(),user.getAge(),user.getCard(),user.getAddress(),user.getPhone(),user.getEmail(),user.getCode()};
		int result=0;
		try {
			result = dbutil.execute(sql, param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
