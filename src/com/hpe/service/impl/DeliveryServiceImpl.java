/**
 * 
 */
package com.hpe.service.impl;

import com.hpe.dao.IDeliveryDao;
import com.hpe.dao.impl.DeliveryDaoImpl;
import com.hpe.pojo.Delivery;
import com.hpe.service.IDeliveryService;


/** 
 * 类描述：
 * 作者： suhang
 * 创建日期：2019年9月8日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public class DeliveryServiceImpl implements IDeliveryService {

private IDeliveryDao deliveryDao = new DeliveryDaoImpl();
	
	@Override
	public int updateDelivery(Delivery Delivery) {
		
		return deliveryDao.updateDelivery(Delivery);
	}

	@Override
	public Delivery getDelivery() {
		// TODO Auto-generated method stub
		return deliveryDao.getDelivery();
	}


}
