package com.cv.daoImpl;

import java.util.List;

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
		// TODO Auto-generated method stub
		this.hibernateTemplate.saveOrUpdate(recognition);

	}

	@Override
	@Transactional
	public List<Recognition> listRecognition() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from Recognition");
	}

}
