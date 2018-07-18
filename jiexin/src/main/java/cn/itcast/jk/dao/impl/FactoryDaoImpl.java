package cn.itcast.jk.dao.impl;

import cn.itcast.jk.domain.FactoryC;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.itcast.jk.dao.FactoryDao;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014-3-12
 */
@Repository
public class FactoryDaoImpl extends BaseDaoImpl<FactoryC> implements FactoryDao{

    public void changeState(Integer state,String[] id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List list = Arrays.asList(id);
        System.out.println("转换后的集合为 =" + list.toString());
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i < id.length;i++){
            if(i == id.length - 1){
                sb.append(id[i] + "\"");
                break;
            }
            sb.append("\"" + id[i]);
            sb.append("\",\"");

        }
        System.out.println("转换后为:" + sb.toString());
        String sql = "update factory_c set state=" + state + " where factory_id in (" + sb.toString() + ")";
        SQLQuery sqlQuery = session.createSQLQuery(sql);
        sqlQuery.executeUpdate();
        tx.commit();


    }

    public List<FactoryC> findFactoryByState(Integer state) {
        Criteria criteria = sessionFactory.openSession().createCriteria(FactoryC.class);
        criteria.add(Restrictions.eq("state",state));
        return criteria.list();
    }
}
