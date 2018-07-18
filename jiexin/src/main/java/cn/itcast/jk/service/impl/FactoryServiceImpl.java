package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import cn.itcast.jk.domain.FactoryC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.jk.dao.FactoryDao;
import cn.itcast.jk.service.FactoryService;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014-3-12
 */
@Service
public class FactoryServiceImpl implements FactoryService {
	@Autowired
	FactoryDao factoryDao;
	
	public List<FactoryC> findFactory(FactoryC factory) {
		return factoryDao.find(factory);
	}

	/* (non-Javadoc)
	 * @see cn.itcast.jk.service.FactoryService#get(java.io.Serializable)
	 */
	public FactoryC getFactory(Serializable id) {
		// TODO Auto-generated method stub
		return factoryDao.get(id);
	}

	/* (non-Javadoc)
	 * @see cn.itcast.jk.service.FactoryService#insert(cn.itcast.jk.domain.Factory)
	 */
	public void insertFactory(FactoryC factory) {
		// TODO Auto-generated method stub
		factory.setFactoryId(UUID.randomUUID().toString());
		factoryDao.insert(factory);
	}

	/* (non-Javadoc)
	 * @see cn.itcast.jk.service.FactoryService#update(cn.itcast.jk.domain.Factory)
	 */
	public void updateFactory(FactoryC factory) {
		// TODO Auto-generated method stub
		factoryDao.update(factory);
	}

	/* (non-Javadoc)
	 * @see cn.itcast.jk.service.FactoryService#delete(java.io.Serializable)
	 */
	public void deleteFactory(FactoryC factory) {
		// TODO Auto-generated method stub
		factoryDao.delete(factory);
	}

	public void changeState(Integer state, String[] factoryId) {
		factoryDao.changeState(state,factoryId);
	}

	public List<FactoryC> findFactoryByState(Integer state) {
		return factoryDao.findFactoryByState(state);
	}

	/* (non-Javadoc)
	 * @see cn.itcast.jk.service.FactoryService#delete(java.io.Serializable[])
	 */
	/*
	public void delete(Serializable[] ids) {
		// TODO Auto-generated method stub
		factoryDao.delete(ids);
	}
	*/


}
