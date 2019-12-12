/**
 * 
 */
package com.hpe.dao;

import java.util.List;

import com.hpe.pojo.Menus;
import com.hpe.pojo.Order;
import com.hpe.pojo.OrdersInfo;
import com.hpe.pojo.Statistics;
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
public interface IOrderDao {

	/**
	 * 
	 * 方法描述：添加订单
	 * @param order
	 * @return 影响的行数
	 */
	int addOrder(Order order);
	
	/**
	 * 
	 * 方法描述：多条件查询
	 * @param page 分页信息
	 * @param ordersInfo 查询条件
	 * @return 查询订单
	 */
	Page getOrderSearch(Page page, OrdersInfo ordersInfo);
	
	/**
	 * 
	 * 方法描述：
	 * @param delivery
	 * @return
	 */
	List<OrdersInfo> searchDelivery(int id,String delivery);
	
	/**
	 * 
	 * 方法描述：获取销售统计数据
	 * @return 统计信息
	 */
	List<Statistics>  getStatistics(String date);
	
	/**
	 * 
	 * 方法描述：
	 * @param id
	 * @return
	 */
	int confirm(int id);
	
	/**
	 * 
	 * 方法描述：
	 * @param id
	 * @return
	 */
	int delete(int id);
	
	/**
	 * 
	 * 方法描述：
	 * @param order
	 * @return
	 */
	int sumOrder(Menus menus, Order order);
	
}
