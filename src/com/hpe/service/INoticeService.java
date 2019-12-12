/**
 * 
 */
package com.hpe.service;

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
public interface INoticeService {

	/** 
	 * 方法描述：
	 * @param notice
	 * @return
	 */
	int addNotice(Notice notice);

	/** 
	 * 方法描述：
	 * @param id
	 * @return
	 */	
	int deleteNotice(int id);

	/** 
	 * 方法描述：
	 * @return
	 */	
	List<Notice> getNoticeAll();

	/** 
	 * 方法描述：
	 * @param id
	 * @return
	 */	
	Notice getNoticeById(int id);
}
