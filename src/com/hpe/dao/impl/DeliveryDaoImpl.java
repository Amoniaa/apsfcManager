/**
 * 
 */
package com.hpe.dao.impl;

import com.hpe.dao.IDeliveryDao;
import com.hpe.pojo.Delivery;
import com.hpe.util.DBUtil;

/** 
 * 类描述：
 * 作者： suhang
 * 创建日期：2019年9月8日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public class DeliveryDaoImpl implements IDeliveryDao {

private DBUtil dbutil = new DBUtil();
	
	@Override
	public int updateDelivery(Delivery delivery) {
		String sql = "update delivery set name=?,lunchtime=?,dinnertime=?,phone=?,contacts=?,content=?,times=? where id=1";
		Object[] param = {delivery.getName(),delivery.getLunchtime(),delivery.getDinnertime(),delivery.getPhone(),delivery.getContacts(), delivery.getContent(), delivery.getTimes() };
		int result = 0;
		try {
			result = dbutil.execute(sql, param);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Delivery getDelivery() {
		String sql = "select * from delivery where id=1";
		Delivery delivery = null;
		try {
			delivery = (Delivery) dbutil.getObject(Delivery.class, sql, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return delivery;
	}

}
