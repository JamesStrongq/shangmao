package cn.itcast.jk.service;

import cn.itcast.jk.domain.ExtCproductC;
import cn.itcast.jk.domain.FactoryC;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014-3-12
 */
public interface ExtCproductService {
	 List<ExtCproductC> findExtCproductC(ExtCproductC extCproductC);
	 ExtCproductC getExtCproductC(Serializable id);
	 void insertExtCproductC(ExtCproductC extCproductC);
	 void updateExtCproductC(ExtCproductC extCproductC);
	 void deleteExtCproductC(ExtCproductC extCproductC);
	List<ExtCproductC> findExtCproductById(String contractProductId);

}

