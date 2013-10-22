package com.cv.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cv.dao.ConditionDao;
import com.cv.model.Condition;
import com.cv.service.ConditionService;

@Repository
public class ConditionDaoImpl implements ConditionDao {

	private HibernateTemplate hibernateTemplate;
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	@Transactional
	public void addCondition(Condition condition) {
		this.hibernateTemplate.saveOrUpdate(condition);

	}

	@Override
	@Transactional
	public List<Condition> listCondition() {
		return this.hibernateTemplate.find("from Condition");
	}

}
