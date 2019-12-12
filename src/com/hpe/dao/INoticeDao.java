/**
 * 
 */
package com.hpe.dao;

import java.util.List;

import com.hpe.pojo.Notice;

/** 
 * 类描述：
 * 作者： WangJiayi 
 * 创建日期：2019年9月4日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public interface INoticeDao {


	/** 
	 * 方法描述：添加新公告
	 * @param notice
	 * @return 影响的行数
	 */
	int addNotice(Notice notice);

	/** 
	 * 方法描述：删除公告
	 * @param id
	 * @return 影响的行数
	 */	
	int deleteNotice(int id);

	/** 
	 * 方法描述：查询所有公告
	 * @return 影响的行数
	 */	
	List<Notice> getNoticeAll();

	/** 
	 * 方法描述：根据id查询
	 * @param id
	 * @return 公告信息
	 */	
	Notice getNoticeById(int id);
	
}
