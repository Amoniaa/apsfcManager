/**
 * 
 */
package com.hpe.pojo;

/** 
 * 类描述：
 * 作者： wanwenlong 
 * 创建日期：2019年9月7日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public class Statistics {

	private String menuname;//菜单名
	private Double sum;//数量
	private String price;//单价
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public Double getSum() {
		return sum;
	}
	public void setSum(Double sum) {
		this.sum = sum;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Statistics(String menuname, Double sum, String price) {
		super();
		this.menuname = menuname;
		this.sum = sum;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Statistics [menuname=" + menuname + ", sum=" + sum + ", price=" + price + "]";
	}
	public Statistics() {
		super();
	}
	
}
