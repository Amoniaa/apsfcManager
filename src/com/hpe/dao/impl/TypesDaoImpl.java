/**
 * 
 */
package com.hpe.dao.impl;

import java.util.List;

import com.hpe.dao.ITypesDao;
import com.hpe.pojo.Types;
import com.hpe.util.DBUtil;

/** 
 * 类描述：
 * 作者：wanghongyuan
 * 创建日期：2019年9月3日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public class TypesDaoImpl implements ITypesDao {

	private DBUtil dbutil=new DBUtil();
	@Override
	public List<Types> getTypesAll() {
		String sql="select * from types";
		List list=null;
		try {
			list = dbutil.getQueryList(Types.class, sql, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int addTypes(Types types) {
		String sql="insert into types(name) values(?)";
		Object[] param={types.getName()};
		int result=0;
		try {
			result = dbutil.execute(sql, param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Types getTypesByName(String name) {
		String sql="select * from types where name=?";
		Object[] param={name};
		Types types=null;
		//执行描述
		try {
			types = (Types) dbutil.getObject(Types.class, sql, param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//返回查询结果
		return types;
	}

	@Override
	public int updateTypes(Types types) {
		String sql="update types set name=? where id=?";
		Object[] param={types.getName(),types.getId()};
		int result=0;
		try {
			result = dbutil.execute(sql, param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Types getTypesById(int id) {
		String sql="select * from types where id=?";
		Object[] param={id};
		Types types=null;
		//执行描述
		try {
			types = (Types) dbutil.getObject(Types.class, sql, param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//返回查询结果
		return types;
	}

	@Override
	public int deleteTypes(int id) {
		String sql = "DELETE FROM types WHERE id = ?";
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

}
