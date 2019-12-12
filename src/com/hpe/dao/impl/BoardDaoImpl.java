/**
 * 
 */
package com.hpe.dao.impl;

import com.hpe.dao.IBoardDao;
import com.hpe.pojo.Board;
import com.hpe.util.DBUtil;
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
public class BoardDaoImpl implements IBoardDao {

	private DBUtil dbutil = new DBUtil();
	
	@Override
	public int addBoard(Board board) {
		String sql = "insert into board(username,content,times) values(?,?,?)";
		Object[] param = {board.getUsername(), board.getContent(), board.getTimes() };
		int result = 0;
		try {
			result = dbutil.execute(sql, param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteBoard(int id) {
		String sql = "delete from board where id=?";
		Object[] param = {id };
		int result = 0;
		try {
			result = dbutil.execute(sql, param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Page getBoard(Page page) {
		String sql = "select * from board order by times desc";
		Page page1 = null;
		page1 = dbutil.getQueryPage(Board.class, sql, null, page);
		return page1;
	}

	@Override
	public Page getBoardByName(Page page, String username) {
		String sql = "select * from board where username=? order by times desc";
		Object[] param = {username };
		Page page1 = null;
		page1 = dbutil.getQueryPage(Board.class, sql, param, page);
		return page1;
	}

	@Override
	public int updateBoard(Board board) {
		String sql = "update board set content=?,times=? where id=?";
		Object[] param = {board.getContent(), board.getTimes(), board.getId() };
		int result = 0;
		try {
			result = dbutil.execute(sql, param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Board getBoardById(int id) {
		String sql = "select * from board where id=?";
		Object[] param = {id };
		Board board = null;
		try {
			board = (Board) dbutil.getObject(Board.class, sql, param);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return board;
	}

}
