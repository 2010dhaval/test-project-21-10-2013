package com.cv.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cv.dao.AnswerDao;
import com.cv.model.Answer;

@Repository
public class AnswerDaoImpl implements AnswerDao {

	private HibernateTemplate hibernateTemplate;
	@SuppressWarnings("unused")
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	public void addOrEditAnswer(Answer answer) {
		
		this.hibernateTemplate.saveOrUpdate(answer);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Answer> getAnswerModelList() {
		return this.hibernateTemplate.find("from Answer");
	}
}
