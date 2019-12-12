/**
 * 
 */
package com.hpe.dao;

import java.util.List;

import com.hpe.pojo.NoticeRocking;

/** 
 * 类描述：
 * 作者：wanghongyuan
 * 创建日期：2019年9月6日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public interface INoticeRockingDao {

	/**
	 * 
	 * 方法描述：
	 * @param 
	 * @return 
	 */
	List<NoticeRocking> getAll();
	
	/**
	 * 
	 * 方法描述：根据id查询
	 * @param id
	 * @return 类别信息
	 */
	NoticeRocking getNoticeById(int id);
}
