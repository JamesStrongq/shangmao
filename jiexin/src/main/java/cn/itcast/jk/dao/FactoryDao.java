package cn.itcast.jk.dao;

import cn.itcast.jk.domain.FactoryC;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014-3-12
 */
public interface FactoryDao extends BaseDao<FactoryC> {
    public void changeState(Integer state,String[] id);
    public List<FactoryC> findFactoryByState(Integer state);

}
