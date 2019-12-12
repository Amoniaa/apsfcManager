/**
 * 
 */
package com.hpe.pojo;

/** 
 * 类描述：
 * 作者：wanghongyuan
 * 创建日期：2019年9月6日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public class OrdersInfo {

	private int id;//编号
	private int userid;
	private String menuname;
	private String date;
	private int delivery;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getDelivery() {
		return delivery;
	}
	public void setDelivery(int delivery) {
		this.delivery = delivery;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "OrdersInfo [userid=" + userid + ", menuname=" + menuname + ", date=" + date + ", delivery=" + delivery
				+ "]";
	}
	
}
