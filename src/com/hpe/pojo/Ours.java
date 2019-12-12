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
public class Ours {

	private int id=1;
	private String name;//标题
	private String content;//正文
	private String times;//发布时间
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
		return "Ours [id=" + id + ", name=" + name + ", content=" + content + ", times=" + times + "]";
	}
	public Ours(String name, String content, String times) {
		super();
		this.name = name;
		this.content = content;
		this.times = times;
	}
	public Ours() {
		super();
	}
	
}
