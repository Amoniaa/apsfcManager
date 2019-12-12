/**
 * 
 */
package com.hpe.pojo;

/** 
 * 类描述：
 * 作者： suhang
 * 创建日期：2019年9月8日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public class Delivery {
	private int id=1;
	private String name;//标题
	private String content;//正文
	private String times;//发布时间
	private String lunchtime;//午餐时间
	private String dinnertime;//晚餐时间
	private String phone;//联系电话
	private String contacts;//联系人
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	public String getLunchtime() {
		return lunchtime;
	}
	public void setLunchtime(String lunchtime) {
		this.lunchtime = lunchtime;
	}
	public String getDinnertime() {
		return dinnertime;
	}
	public void setDinnertime(String dinnertime) {
		this.dinnertime = dinnertime;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	@Override
	public String toString() {
		return "Delivery [id=" + id + ", name=" + name + ", content=" + content + ", times=" + times + ", lunchtime="
				+ lunchtime + ", dinnertime=" + dinnertime + ", phone=" + phone + ", contacts=" + contacts + "]";
	}
	public Delivery(String name, String content, String times, String lunchtime, String dinnertime,
			String phone, String contacts) {
		super();
		this.name = name;
		this.content = content;
		this.times = times;
		this.lunchtime = lunchtime;
		this.dinnertime = dinnertime;
		this.phone = phone;
		this.contacts = contacts;
	}
	public Delivery() {
		super();
	}

}
