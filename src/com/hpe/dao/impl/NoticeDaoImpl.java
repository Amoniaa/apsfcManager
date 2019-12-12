/**
 * 
 */
package com.hpe.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.hpe.dao.INoticeDao;
import com.hpe.pojo.Notice;
import com.hpe.pojo.Types;
import com.hpe.util.DBUtil;

/** 
 * 类描述：
 * 作者： WangJiayi 
 * 创建日期：2019年9月4日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public class NoticeDaoImpl implements INoticeDao {

	private DBUtil dbutil = new DBUtil();

	@Override
	public int addNotice(Notice notice) {
		
		String sql = "INSERT INTO notice (name, content, times) values(?, ?, ?)";
		Object[] param = {notice.getName(), notice.getContent(), notice.getTimes()};
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
	public int deleteNotice(int id) {

		String sql = "DELETE FROM notice WHERE id = ?";
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
	public List<Notice> getNoticeAll() {
		
		String sql = "SELECT * FROM notice ORDER BY times DESC";
		List list = null;
		try {
			list = dbutil.getQueryList(Notice.class, sql, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}


	@Override
	public Notice getNoticeById(int id) {

		String sql="SELECT * FROM notice WHERE id=?";
		Object[] param = {id};
		Notice notice = null;
		try {
			notice = (Notice) dbutil.getObject(Notice.class, sql, param);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//返回查询结果
		return notice;
	}

}
