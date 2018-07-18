package cn.itcast.jk.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import cn.itcast.jk.domain.FactoryC;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.jk.dao.BaseDao;

public abstract class BaseDaoImpl<T> implements BaseDao<T>{

	@Autowired
	SessionFactory sessionFactory;
	
	public List<T> find(T entiy) {
		Criteria criteria = sessionFactory.openSession().createCriteria(entiy.getClass());

		return criteria.list();
	}
	public T get(Serializable id) {

		return sessionFactory.openSession().get((Class <T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0],id);
	}

	public void insert(T entity) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(entity);
		transaction.commit();
	}

	public void update(T entity) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(entity);
		transaction.commit();
	}

	public void delete(T entity) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(entity);
		transaction.commit();
	}

}
