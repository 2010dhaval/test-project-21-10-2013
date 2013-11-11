package com.cv.security;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cv.model.CustomUserDetails;
import com.cv.model.User;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	Query query;
	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		System.out.println("in custom service");
		Session session = this.hibernateTemplate.getSessionFactory()
				.getCurrentSession();
		query = session
				.createQuery("FROM User as usr WHERE username=:userName");
		query.setParameter("userName", username).uniqueResult();

		try {
			User userTemp = (User) this.query.uniqueResult();
			userTemp.getRole().getRoleId();
			CustomUserDetails user = new CustomUserDetails(userTemp);
			System.out.println("role " + userTemp.getRole().getRoleId());
			String result = userTemp.getRole().getRoleId();
			// String hql =
			// "select businessFunction from RoleBusinessFunction where ROLE_ID=:result";
			System.out.println("in else" + user.getPassword());
			List<String> roles = new ArrayList<String>();
			roles.add(userTemp.getRole().getRoleName());
			user.setRoles(roles);
			System.out.println("user details here");
			return user;
		} catch (EmptyResultDataAccessException erdae) {
			erdae.getStackTrace();
			throw new UsernameNotFoundException("username not found");
		}
	}

}
