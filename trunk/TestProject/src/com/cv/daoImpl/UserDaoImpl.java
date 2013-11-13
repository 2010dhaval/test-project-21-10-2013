package com.cv.daoImpl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cv.dao.UserDao;
import com.cv.model.CustomUserDetails;
import com.cv.model.Password;
import com.cv.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	private HibernateTemplate hibernateTemplate;
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	@Transactional
	public boolean confirmPassword(Password password, User user) {
		int count = 0;
		Session session = this.hibernateTemplate.getSessionFactory()
				.getCurrentSession();

		int userId = ((CustomUserDetails) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal()).getUserId();
		System.out.println("id==" + userId);
		String sqlString = "SELECT COUNT(*) FROM User WHERE userId=:userId AND password=:pass";
		org.hibernate.Query query = session.createQuery(sqlString);
		query.setParameter("userId", userId);
		query.setString("pass", user.getPassword());
		for (Iterator it = query.iterate(); it.hasNext();) {
			it.next();
			count++;
		}
		System.out.println("rows=" + count);
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	@Transactional
	public void updatePassword(User user, Password password) {
		int userId = ((CustomUserDetails) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal()).getUserId();
		String hql = "from User Where userId=:userId";
		Session session = this.hibernateTemplate.getSessionFactory()
				.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter("userId", userId).uniqueResult();
		User u = (User) query.uniqueResult();
		System.out.println("" + u);
		System.out.println("in update pass = " + userId);

		String hashPass = password.getNewPassword();
		u.setPassword(hashPass);
		System.out.println("pass" + hashPass);
		u.setUserId(userId);
		this.hibernateTemplate.saveOrUpdate(u);
	}

	@Override
	@Transactional
	public List<String> getRolesForUserId(String roleId) {
		System.out.println("role--" + roleId);
		Session session = this.hibernateTemplate.getSessionFactory()
				.getCurrentSession();
		System.out.println(" getRolesForUserId ");
		String hql = "select roleName from Role where roleId=:ddd";
		Query query = session.createQuery(hql);
		query.setParameter("ddd", roleId);
		System.out.println(" query " + query.getQueryString());
		List<String> qry = (List<String>) query.list();
		System.out.println(" done ");
		return qry;
	}

	@Override
	@Transactional
	public User getUserDetails(String username, String password) {
		Session session = this.hibernateTemplate.getSessionFactory()
				.getCurrentSession();
		String hql = "from User where username=:username and password=:pass";
		org.hibernate.Query query = session.createQuery(hql);
		query.setParameter("username", username);
		query.setString("pass", password);
		User u = (User) query.uniqueResult();
		return u;
	}

}
