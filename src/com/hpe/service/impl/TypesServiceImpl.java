/**
 * 
 */
package com.hpe.service.impl;

import java.util.List;

import com.hpe.dao.ITypesDao;
import com.hpe.dao.impl.TypesDaoImpl;
import com.hpe.pojo.Types;
import com.hpe.service.ITypesService;

/** 
 * 类描述：
 * 作者：wanghongyuan
 * 创建日期：2019年9月3日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public class TypesServiceImpl implements ITypesService {

	private ITypesDao typesDao=new TypesDaoImpl();
	@Override
	public List<Types> getTypesAll() {
		return typesDao.getTypesAll();
	}

	@Override
	public int addTypes(Types types) {
		//根据用户名查询
		Types type=typesDao.getTypesByName(types.getName());
		if(type!=null){
			return -1;
		}
		return typesDao.addTypes(types);
	}

	@Override
	public int updateTypes(Types types) {
		//根据id查询
		Types ty=typesDao.getTypesById(types.getId());
		if(ty.getName().equals(types.getName())){
			return 1;
		}
		//根据name查询
		Types type=typesDao.getTypesByName(types.getName());
		if(type!=null){
			return -1;
		}
		return typesDao.updateTypes(types);
	}

	@Override
	public Types getTypesById(int id) {
		return typesDao.getTypesById(id);
	}

	@Override
	public int deleteTypes(int id) {
		return typesDao.deleteTypes(id);
	}

}
