/**
 * 
 */
package com.hpe.service.impl;

import java.util.List;

import com.hpe.dao.INoticeRockingDao;
import com.hpe.dao.impl.NoticeRockingDaoImpl;
import com.hpe.pojo.NoticeRocking;
import com.hpe.service.INoticeRockingService;

/** 
 * 类描述：
 * 作者：wanghongyuan
 * 创建日期：2019年9月6日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public class NoticeRockingServiceImpl implements INoticeRockingService {
	private INoticeRockingDao noticeRockingDao=new NoticeRockingDaoImpl();

	@Override
	public List<NoticeRocking> getRocking() {
		return noticeRockingDao.getAll();
	}

	@Override
	public NoticeRocking getNoticeById(int id) {
		return noticeRockingDao.getNoticeById(id);
	}

}
