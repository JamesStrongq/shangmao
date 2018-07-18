package cn.itcast.jk.dao.impl;

import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.dao.ExtCproductDao;
import cn.itcast.jk.dao.FactoryDao;
import cn.itcast.jk.domain.ExtCproductC;
import cn.itcast.jk.domain.FactoryC;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014-3-12
 */
@Repository
public class ExtCproductDaoImpl extends BaseDaoImpl<ExtCproductC> implements ExtCproductDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<ExtCproductC> findExtCproductById(String contractProductId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(ExtCproductC.class);
        criteria.add(Restrictions.eq("contractProductId",contractProductId));
        transaction.commit();
        return criteria.list();
    }
}
