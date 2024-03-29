package com.cv.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cv.dao.RecognitionDao;
import com.cv.model.Recognition;

@Repository
public class RecognitionDaoImpl implements RecognitionDao {

	private HibernateTemplate hibernateTemplate;
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	@Transactional
	public void addRecognition(Recognition recognition) {
		this.hibernateTemplate.saveOrUpdate(recognition);

	}

	@Override
	@Transactional
	public List<Recognition> listRecognition() {
		return this.hibernateTemplate.find("from Recognition");
	}

	@Override
	@Transactional
	public Recognition getRecVoByRecId(Integer recId) {

		return (Recognition) this.hibernateTemplate.getSessionFactory()
				.getCurrentSession().get(Recognition.class, recId);
	}

	@Override
	@Transactional
	public void addRecognationByDozer(Recognition recognition) {
		this.hibernateTemplate.saveOrUpdate(recognition);
	}

	@Override
	@Transactional
	public List<Recognition> listRecognitionByDozer() {
		return this.hibernateTemplate.find("from Recognition");
	}

	@Override
	@Transactional
	public List<Recognition> listRecognitionByManual() {
		return this.hibernateTemplate.find("from Recognition");
	}

	@Override
	@Transactional
	public void addRecognationByManual(Recognition recognition) {
		this.hibernateTemplate.saveOrUpdate(recognition);
	}

	@Override
	@Transactional
	public Recognition getRecVoByRecIdByManual(Integer recId) {
		return (Recognition) this.hibernateTemplate.getSessionFactory()
				.getCurrentSession().get(Recognition.class, recId);
	}

	@Override
	@Transactional
	public Recognition getRecVoByRecIdByDozer(Integer recId) {
		return (Recognition) this.hibernateTemplate.getSessionFactory()
				.getCurrentSession().get(Recognition.class, recId);
	}

}
