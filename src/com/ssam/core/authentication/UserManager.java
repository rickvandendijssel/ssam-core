package com.ssam.core.authentication;

import java.util.List;

import org.hibernate.Criteria;

import com.ssam.core.authentication.datafilter.UserDataFilter;
import com.ssam.core.authentication.datafilter.UserListDataFilter;
import com.ssam.core.main.CoreFactory;
import com.ssam.core.util.HibernateUtil;

public class UserManager {
	
	private HibernateUtil hibernateUtil = CoreFactory.getCoreFactory().getHibernateUtil();
	
	public List<User> getUserList(UserListDataFilter filter){
		org.hibernate.Session dbSession = hibernateUtil.getSession();
		hibernateUtil.startNewTransaction();
		Criteria criteria = dbSession.createCriteria(User.class);
		filter.setFilter(criteria);
		@SuppressWarnings("unchecked")
		List<User> result = (List<User>) criteria.list();
		hibernateUtil.commitTransaction();
		return result;
	}
	
	public User getUser(UserDataFilter filter){
		org.hibernate.Session dbSession = hibernateUtil.getSession();
		hibernateUtil.startNewTransaction();
		Criteria criteria = dbSession.createCriteria(User.class);
		filter.setFilter(criteria);
		User result = (User) criteria.uniqueResult();
		hibernateUtil.commitTransaction();
		return result;
	}
	
	public Long addUser(User user){
		org.hibernate.Session dbSession = hibernateUtil.getSession();
		hibernateUtil.startNewTransaction();
		Long userID = (Long)dbSession.save(user);
		hibernateUtil.commitTransaction();
		return userID;
	}
	
	public void updateUser(User user){
		org.hibernate.Session dbSession = hibernateUtil.getSession();
		hibernateUtil.startNewTransaction();
		dbSession.update(user);
		hibernateUtil.commitTransaction();
	}
	
}
