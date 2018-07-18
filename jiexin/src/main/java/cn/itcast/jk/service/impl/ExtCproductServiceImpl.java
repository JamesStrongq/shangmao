package cn.itcast.jk.service.impl;

import cn.itcast.jk.dao.ExtCproductDao;
import cn.itcast.jk.dao.FactoryDao;
import cn.itcast.jk.domain.ExtCproductC;
import cn.itcast.jk.domain.FactoryC;
import cn.itcast.jk.service.ExtCproductService;
import cn.itcast.jk.service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014-3-12
 */
@Service
public class ExtCproductServiceImpl implements ExtCproductService {

	@Autowired
	private ExtCproductDao extCproductDao;

	public List<ExtCproductC> findExtCproductC(ExtCproductC extCproductC) {
		return extCproductDao.find(extCproductC);
	}

	public ExtCproductC getExtCproductC(Serializable id) {
		return extCproductDao.get(id);
	}

	public void insertExtCproductC(ExtCproductC extCproductC) {
		extCproductDao.insert(extCproductC);
	}

	public void updateExtCproductC(ExtCproductC extCproductC) {
		extCproductDao.update(extCproductC);
	}

	public void deleteExtCproductC(ExtCproductC extCproductC) {
		extCproductDao.delete(extCproductC);
	}

	public List<ExtCproductC> findExtCproductById(String contractProductId) {
		return extCproductDao.findExtCproductById(contractProductId);
	}
}
