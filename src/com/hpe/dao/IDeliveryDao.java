/**
 * 
 */
package com.hpe.dao;

import com.hpe.pojo.Delivery;

/** 
 * 类描述：
 * 作者： suhang
 * 创建日期：2019年9月8日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public interface IDeliveryDao {
	/**
	 * 
	 * 方法描述：更新配送说明
	 * @param Delivery
	 * @return 影响的行数
	 */
	int updateDelivery(Delivery Delivery);
	
	/**
	 * 
	 * 方法描述：查询配送说明
	 * @return 配送说明
	 */
	Delivery getDelivery();

}
