/**
 * 
 */
package com.hpe.service.impl;

import com.hpe.dao.IBoardDao;
import com.hpe.dao.impl.BoardDaoImpl;
import com.hpe.pojo.Board;
import com.hpe.service.IBoardService;
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
public class BoardServiceImpl implements IBoardService {

	private IBoardDao boardDao = new BoardDaoImpl();

	@Override
	public int addBoard(Board board) {
		// TODO Auto-generated method stub
		return boardDao.addBoard(board);
	}

	@Override
	public int deleteBoard(int id) {
		// TODO Auto-generated method stub
		return boardDao.deleteBoard(id);
	}

	@Override
	public Page getBoard(Page page) {
		// TODO Auto-generated method stub
		return boardDao.getBoard(page);
	}

	@Override
	public Page getBoardByName(Page page, String username) {
		
		return boardDao.getBoardByName(page, username);
	}

	@Override
	public int updateBoard(Board board) {
		// TODO Auto-generated method stub
		return boardDao.updateBoard(board);
	}

	@Override
	public Board getBoardById(int id) {
		// TODO Auto-generated method stub
		return boardDao.getBoardById(id);
	}
	
	
}
