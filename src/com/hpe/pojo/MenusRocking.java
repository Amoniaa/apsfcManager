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
public class MenusRocking {

	private int id;//编号
	private String name;//菜品名称
	private String sums1;//会员销售数量
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSums1() {
		return sums1;
	}
	public void setSums1(String sums1) {
		this.sums1 = sums1;
	}
	
	@Override
	public String toString() {
		return "MenusRocking [id=" + id + ", name=" + name + ", sums1=" + sums1 + "]";
	}
	
}

