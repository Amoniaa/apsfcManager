/**
 * 
 */
package com.hpe.dao;

import com.hpe.pojo.Ours;

/** 
 * 类描述：
 * 作者： wanwenlong 
 * 创建日期：2019年9月7日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public interface IOursDao {

	/**
	 * 
	 * 方法描述：更新关于我们
	 * @param Ours
	 * @return 影响的行数
	 */
	int updateOurs(Ours Ours);
	
	/**
	 * 
	 * 方法描述：查询关于我们
	 * @return 关于我们
	 */
	Ours getOurs();
}
