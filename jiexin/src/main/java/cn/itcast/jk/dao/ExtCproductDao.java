package cn.itcast.jk.dao;

import cn.itcast.jk.domain.ExtCproductC;
import cn.itcast.jk.domain.FactoryC;

import java.util.List;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014-3-12
 */
public interface ExtCproductDao extends BaseDao<ExtCproductC> {

    List<ExtCproductC> findExtCproductById(String contractProductId);
}
