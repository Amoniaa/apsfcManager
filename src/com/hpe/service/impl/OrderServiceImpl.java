/**
 * 
 */
package com.hpe.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.hpe.dao.IMenusDao;
import com.hpe.dao.IOrderDao;
import com.hpe.dao.impl.MenusDaoImpl;
import com.hpe.dao.impl.OrderDaoImpl;
import com.hpe.pojo.Menus;
import com.hpe.pojo.Order;
import com.hpe.pojo.OrdersInfo;
import com.hpe.pojo.ShoppingCart;
import com.hpe.pojo.Statistics;
import com.hpe.service.IOrderService;
import com.hpe.util.DBUtil;
import com.hpe.util.Page;

/** 
 * 类描述：
 * 作者： WangJiayi 
 * 创建日期：2019年9月6日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public class OrderServiceImpl implements IOrderService {

	private IOrderDao orderDao = new OrderDaoImpl();
	private IMenusDao menusDao=new MenusDaoImpl();
	
	@Override
	public boolean addOrder(int userId, List<ShoppingCart> list) throws Exception {
		boolean flag = false;
		try {
			//开启事务
			DBUtil.beginTranscation();
			//遍历添加
			for(ShoppingCart cart : list) {
				Order order = new Order();
				order.setUserid(userId);
				order.setMenuid(cart.getMenuid());
				order.setMenusum(String.valueOf(cart.getSum1()));
				order.setDelivery("0");
				order.setTimes(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				orderDao.addOrder(order);
				Menus menus = menusDao.getMenusById(order.getMenuid(), DBUtil.getConnection());
				orderDao.sumOrder(menus, order);
			}
			//提交事务
			DBUtil.endTranscation();
			flag = true;
		} catch (Exception e) {
			try {
				//回滚事务
				DBUtil.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			//关闭连接
			DBUtil.closeConn();
		}
		return flag;
	}

	@Override
	public Page getOrderSearch(Page page, OrdersInfo ordersInfo) {
		return orderDao.getOrderSearch(page, ordersInfo);
	}

	@Override
	public List<OrdersInfo> searchDelivery(int id, String delivery) {
		return orderDao.searchDelivery(id, delivery);
	}

	@Override
	public int confirm(int id) {
		return orderDao.confirm(id);
	}

	@Override
	public int delete(int id) {
		return orderDao.delete(id);
	}

	@Override
	public List<Statistics> getStatistics() {
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		return orderDao.getStatistics(date);
	}

}
