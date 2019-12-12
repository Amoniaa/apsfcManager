/**
 * 
 */
package com.hpe.pojo;

import java.util.Date;

/** 
 * 类描述：
 * 作者： WangJiayi 
 * 创建日期：2019年9月4日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public class Notice {

	private int id;
	
	private String name;
	
	private String content;
	
	private String times;

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

	@Override
	public String toString() {
		return "Note [id=" + id + ", name=" + name + ", content=" + content + ", times=" + times + "]";
	}
	
}
