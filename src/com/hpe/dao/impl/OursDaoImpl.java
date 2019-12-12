/**
 * 
 */
package com.hpe.dao.impl;

import com.hpe.dao.IOursDao;
import com.hpe.pojo.Ours;
import com.hpe.util.DBUtil;

/** 
 * 类描述：
 * 作者： wanwenlong 
 * 创建日期：2019年9月7日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public class OursDaoImpl implements IOursDao {

	private DBUtil dbutil = new DBUtil();
	
	@Override
	public int updateOurs(Ours ours) {
		String sql = "update ours set name=?,content=?,times=? where id=1";
		Object[] param = {ours.getName(), ours.getContent(), ours.getTimes() };
		int result = 0;
		try {
			result = dbutil.execute(sql, param);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Ours getOurs() {
		String sql = "select * from ours where id=1";
		Ours ours = null;
		try {
			ours = (Ours) dbutil.getObject(Ours.class, sql, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ours;
	}

}
