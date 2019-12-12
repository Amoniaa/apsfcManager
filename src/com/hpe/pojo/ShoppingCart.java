/**
 * 
 */
package com.hpe.pojo;

/** 
 * 类描述：购物车
 * 作者：wanghongyuan
 * 创建日期：2019年9月5日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public class ShoppingCart {

	private int menuid;//菜品id
	private String name;//菜品名称
	private float price;//菜品价格
	private int sum;//数量
	private float price1;//菜品价格
	private int sum1;//数量
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public float getPrice1() {
		return price1;
	}
	public void setPrice1(float price1) {
		this.price1 = price1;
	}
	public int getSum1() {
		return sum1;
	}
	public void setSum1(int sum1) {
		this.sum1 = sum1;
	}
	@Override
	public String toString() {
		return "ShoppingCart [menuid=" + menuid + ", name=" + name + ", price=" + price + ", sum=" + sum + ", price1="
				+ price1 + ", sum1=" + sum1 + "]";
	}
	
	
}
