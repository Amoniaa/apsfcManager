/**
 * 
 */
package com.hpe.service.impl;

import com.hpe.dao.IOursDao;
import com.hpe.dao.impl.OursDaoImpl;
import com.hpe.pojo.Ours;
import com.hpe.service.IOursService;

/** 
 * 类描述：
 * 作者： wanwenlong 
 * 创建日期：2019年9月7日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public class OursServiceImpl implements IOursService {

	private IOursDao oursDao = new OursDaoImpl();
	
	@Override
	public int updateOurs(Ours Ours) {
		
		return oursDao.updateOurs(Ours);
	}

	@Override
	public Ours getOurs() {
		// TODO Auto-generated method stub
		return oursDao.getOurs();
	}

}
