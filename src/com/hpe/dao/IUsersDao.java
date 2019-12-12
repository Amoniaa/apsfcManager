/**
 * 
 */
package com.hpe.dao;

import com.hpe.pojo.Users;

/** 
 * 类描述：用户Dao接口
 * 作者：wanghongyuan
 * 创建日期：2019年9月4日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public interface IUsersDao {

	/**
	* 
	* 方法描述：用户登录
	* @param name 用户名
	* @param pwd 密码
	* @return 用户信息
	*/
	Users login(String name,String pwd);
		
	/**
	* 
	* 方法描述：修改用户信息
	* @param user
	* @return 影响的行数
	*/
	int updateUsers(Users users);
		
	/**
	* 
	* 方法描述：根据用户名查询
	* @param name 用户名
	* @return 用户信息
	*/
	Users getUsersByName(String name);
	
	/**
	 * 
	 * 方法描述：添加类别
	 * @param user 类别信息
	 * @return 影响的行数
	 */
	int addUsers(Users user);
	
}
