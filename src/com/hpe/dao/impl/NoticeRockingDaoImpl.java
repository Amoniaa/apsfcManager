/**
 * 
 */
package com.hpe.dao.impl;

import java.util.List;

import com.hpe.dao.INoticeRockingDao;
import com.hpe.pojo.NoticeRocking;
import com.hpe.util.DBUtil;

/** 
 * 类描述：
 * 作者：wanghongyuan
 * 创建日期：2019年9月6日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public class NoticeRockingDaoImpl implements INoticeRockingDao {

	private DBUtil dbutil=new DBUtil();
	
	@Override
	public List<NoticeRocking> getAll() {
		String sql="SELECT id,name,content,times FROM notice ORDER BY times DESC";
		List list=null;
		try {
			list = dbutil.getQueryList(NoticeRocking.class, sql, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public NoticeRocking getNoticeById(int id) {
		String sql="select * from notice where id=?";
		Object[] param={id};
		NoticeRocking notice=null;
		//执行描述
		try {
			notice = (NoticeRocking) dbutil.getObject(NoticeRocking.class, sql, param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//返回查询结果
		return notice;
	}

}
