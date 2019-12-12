/**
 * 
 */
package com.hpe.dao;

import com.hpe.pojo.Board;
import com.hpe.util.Page;

/** 
 * 类描述：
 * 作者： wanwenlong 
 * 创建日期：2019年9月9日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */

//留言板
public interface IBoardDao {

	/**
	 * 
	 * 方法描述：添加新留言
	 * @param board
	 * @return 影响的行数
	 */
	int addBoard(Board board);
	
	/**
	 * 
	 * 方法描述：删除留言
	 * @param id
	 * @return 影响的行数
	 */
	int deleteBoard(int id);
	
	/**
	 * 
	 * 方法描述：分页查询所有留言板
	 * @param page
	 * @return 留言板信息
	 */
	Page getBoard(Page page);
	
	/**
	 * 
	 * 方法描述：根据用户名查询
	 * @return 留言信息
	 */
	Page getBoardByName(Page page, String username);
	
	/**
	 * 
	 * 方法描述：
	 * @param board
	 * @return
	 */
	int updateBoard(Board board);
	
	/**
	 * 
	 * 方法描述：获取留言信息
	 * @param id
	 * @return 留言信息
	 */
	Board getBoardById(int id);
}
