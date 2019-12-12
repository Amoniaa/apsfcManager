/**
 * 
 */
package com.hpe.service;

import com.hpe.pojo.Admin;

/** 
 * 类描述：
 * 作者：wanghongyuan
 * 创建日期：2019年9月2日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public interface IAdminService {

	/**
	 * 
	 * 方法描述：管理员登录
	 * @param name 用户名
	 * @param pwd 密码
	 * @return 管理员信息
	 */
	Admin login(String name,String pwd);
	
	/**
	 * 
	 * 方法描述：修改管理员信息
	 * @param admin 用户名 id 密码
	 * @return 影响的行数
	 */
	int updateAdmin(Admin admin);
}
