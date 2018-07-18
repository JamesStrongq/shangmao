package cn.itcast.jk.dao.impl;

import cn.itcast.jk.dao.ContractProductDao;

import cn.itcast.jk.domain.ContractProductC;
import org.hibernate.*;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;


@Repository
public class ContractProductDaoImpl extends BaseDaoImpl<ContractProductC> implements ContractProductDao {

    @Autowired
    private SessionFactory sessionFactory;


    public List<ContractProductC> findContractProductById(String contractId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(ContractProductC.class);
        criteria.add(Restrictions.eq("contractId",contractId));
        transaction.commit();
        return criteria.list();
    }

    public List<ContractProductC> findForExport(Serializable contractId) {
        Session session = sessionFactory.openSession();
        String sql = "select \n" +
                "\tf.factory_name,cp.*\n" +
                "FROM\n" +
                "(\n" +
                "select * from contract_product_c\n" +
                ") cp\n" +
                "LEFT JOIN\n" +
                "(\n" +
                "select factory_id,factory_name from factory_c\n" +
                ") f\n" +
                "on cp.factory_id=f.factory_id where contract_id in (?1)";
        SQLQuery sqlQuery = session.createSQLQuery(sql);
        sqlQuery.setString(1,(String) contractId);
        List list = sqlQuery.getResultList();
        return null;
    }
}
