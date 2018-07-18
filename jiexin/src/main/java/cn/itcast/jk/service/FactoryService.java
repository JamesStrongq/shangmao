package cn.itcast.jk.service;

import cn.itcast.jk.domain.FactoryC;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014-3-12
 */
public interface FactoryService {
	 List<FactoryC> findFactory(FactoryC factory);
	 FactoryC getFactory(Serializable id);
	 void insertFactory(FactoryC factory);
	 void updateFactory(FactoryC factory);
	 void deleteFactory(FactoryC factory);
	 void changeState(Integer state,String[] factoryId);
	 List<FactoryC> findFactoryByState(Integer state);

}

