/**
 * 
 */
package com.hpe.pojo;

/** 
 * 类描述：
 * 作者： wanwenlong 
 * 创建日期：2019年9月9日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */

//留言板实体类
public class Board {

	private int id;//编号
	private String username;//用户名
	private String content;//内容
	private String times;//时间
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
		return "Board [id=" + id + ", username=" + username + ", content=" + content + ", times=" + times + "]";
	}
	public Board(int id, String username, String content, String times) {
		super();
		this.id = id;
		this.username = username;
		this.content = content;
		this.times = times;
	}
	public Board(String username, String content, String times) {
		super();
		this.username = username;
		this.content = content;
		this.times = times;
	}
	public Board() {
		super();
	}
	
}
