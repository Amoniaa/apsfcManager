/**
 * 
 */
package com.hpe.service.impl;

import java.util.List;

import com.hpe.dao.INoticeDao;
import com.hpe.dao.impl.NoticeDaoImpl;
import com.hpe.pojo.Notice;
import com.hpe.service.INoticeService;

/** 
 * 类描述：
 * 作者： WangJiayi 
 * 创建日期：2019年9月4日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public class NoticeServiceImpl implements INoticeService {


	private INoticeDao noticeDao = new NoticeDaoImpl();
	
	@Override
	public int addNotice(Notice notice) {
		
		return noticeDao.addNotice(notice);
	}


	@Override
	public int deleteNotice(int id) {
		
		return noticeDao.deleteNotice(id);
	}


	@Override
	public List<Notice> getNoticeAll() {
		
		return noticeDao.getNoticeAll();
	}

	@Override
	public Notice getNoticeById(int id) {
		
		return noticeDao.getNoticeById(id);
	}

}
