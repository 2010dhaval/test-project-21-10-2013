package com.cv.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cv.dao.EmployeeDao;
import com.cv.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	private HibernateTemplate hibernateTemplate;
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	@Override
	@Transactional
	public List<Employee> getEmployeeList() {
		List<Employee> list =null;
		try{
			list =  this.hibernateTemplate.find("from Employee");
		
		}catch(Exception ex){
			ex.getStackTrace();
		}
		return list;
	}

}
