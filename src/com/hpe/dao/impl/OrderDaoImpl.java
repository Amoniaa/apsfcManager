/**
 * 
 */
package com.hpe.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.hpe.dao.IOrderDao;
import com.hpe.pojo.Menus;
import com.hpe.pojo.Order;
import com.hpe.pojo.Orders;
import com.hpe.pojo.OrdersInfo;
import com.hpe.pojo.Statistics;
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
public class OrderDaoImpl implements IOrderDao {

	private DBUtil dbutil = new DBUtil();
	@Override
	public int addOrder(Order order) {
		
		String sql = "INSERT INTO orders(menuid, userid, menusum, times, delivery) VALUES(?,?,?,?,?)";
		Object[] param = {order.getMenuid(), order.getUserid(), order.getMenusum(),  
						  order.getTimes(), order.getDelivery()};
		int result = 0;
		try {
			result = dbutil.execute(DBUtil.getConnection(), sql, param);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public int sumOrder(Menus menus, Order order) {	
		String sql = "update menus set sums1=? where id=?";
		int sum1 = Integer.parseInt(order.getMenusum()) + Integer.parseInt(menus.getSums1());
		Object[] param = {String.valueOf(sum1), order.getMenuid()};
		int result = 0;
		try {
			result = dbutil.execute(DBUtil.getConnection(), sql, param);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Page getOrderSearch(Page page, OrdersInfo ordersInfo) {
			
		String sql = " SELECT o.id AS id,u.id AS userid,realname,phone,address,m.name AS menuname,menusum,price1 AS price,times,delivery"  
				   + " FROM menus m INNER JOIN orders o ON m.id=o.menuid"
				   + " INNER JOIN users u ON u.id=o.userid"
				   + " WHERE 1=1";
		List<Object> list = new ArrayList<Object>();
		if(ordersInfo != null){
			//用户id
			int userid = ordersInfo.getUserid();
			if(userid > 0){
				sql += " AND u.id=?";
				list.add(userid);
			}
			//菜品名称
			String menuname = ordersInfo.getMenuname();
			if(menuname != null && menuname.length() > 0){
				sql += " AND m.name LIKE ?";
				list.add("%"+menuname+"%");
			}
			//时间
			String date = ordersInfo.getDate();
			if(date != null && date.length() > 0){
				sql += " AND times LIKE ?";
				list.add("%"+date+"%");
			}
			//派送状态
			int delivery = ordersInfo.getDelivery();
			if(delivery >= 0 && delivery <= 1){
				sql += " AND delivery = ?";
				list.add(delivery);
			}
		}
		sql += " ORDER BY times DESC";
		Page page1 = dbutil.getQueryPage(Orders.class, sql, list.toArray(), page);
		
		return page1;
	}


	@Override
	public List<OrdersInfo> searchDelivery(int id,String delivery) {
		String sql = " SELECT u.id AS userid,realname,phone,address,m.name AS menuname,menusum,price,times,delivery"  
				   + " FROM menus m INNER JOIN orders o ON m.id=o.menuid"
				   + " INNER JOIN users u ON u.id=o.userid"
				   + " WHERE 1=1 AND id=? AND delivery=?";
		Object[] param={id,delivery};
		List list=null;
		try {
			list = dbutil.getQueryList(OrdersInfo.class, sql, param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Statistics> getStatistics(String date) {
		String sql = "SELECT name AS menuname,SUM(menusum) AS sum,price1 AS price FROM menus INNER JOIN orders "
				+ "ON orders.menuid=menus.id WHERE times LIKE ? GROUP BY menuid";
		Object[] param = {("%"+date+"%") };
		List list = null;
		try {
			list = dbutil.getQueryList(Statistics.class, sql, param);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int confirm(int id) {
		
		String sql = "update orders set delivery=1 where id=?";
		Object[] param = {id};
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
	public int delete(int id) {
		
		String sql = "DELETE FROM orders WHERE id=?";
		Object[] param = {id};
		int result = 0;
		try {
			result = dbutil.execute(sql, param);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
