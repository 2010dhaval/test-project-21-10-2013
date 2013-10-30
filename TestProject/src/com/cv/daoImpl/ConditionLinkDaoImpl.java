package com.cv.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cv.dao.ConditionLinkDao;
import com.cv.model.ConditionLink;

@Repository
public class ConditionLinkDaoImpl implements ConditionLinkDao {
	private HibernateTemplate hibernateTemplate;
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	@Transactional
	public List<ConditionLink> getConditionLinkList(Integer recId) {
		return this.hibernateTemplate
				.find("from ConditionLink where recognition.recId=" + recId);
	}

	@Override
	@Transactional
	public void addConditionLink(ConditionLink conditionLink) {
		this.hibernateTemplate.saveOrUpdate(conditionLink);

	}

	@Override
	@Transactional
	public ConditionLink getConditionLinkById(Integer conditionLinkId) {
		return (ConditionLink)this.hibernateTemplate.getSessionFactory().getCurrentSession().get(ConditionLink.class, conditionLinkId);
		
	}
}
