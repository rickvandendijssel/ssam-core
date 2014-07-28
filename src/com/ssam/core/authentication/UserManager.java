package com.ssam.core.authentication;

import java.util.List;

import org.hibernate.Criteria;

import com.ssam.core.main.CoreFactory;
import com.ssam.core.util.HibernateUtil;

public class UserManager {
	
	private HibernateUtil hibernateUtil = CoreFactory.getCoreFactory().getHibernateUtil();
	
	public List<User> getUserList(){
		org.hibernate.Session dbSession = hibernateUtil.createNewSessionAndStartTransaction();
		Criteria criteria = dbSession.createCriteria(User.class);
		@SuppressWarnings("unchecked")
		List<User> result = (List<User>) criteria.list();
		hibernateUtil.commitTransaction(dbSession);
		return result;
	}
	
	public Long addUser(User user){
		org.hibernate.Session dbSession = hibernateUtil.createNewSessionAndStartTransaction();
		Long userID = (Long)dbSession.save(user);
		hibernateUtil.commitTransaction(dbSession);
		return userID;
	}
	
	public void updateUser(User user){
		org.hibernate.Session dbSession = hibernateUtil.createNewSessionAndStartTransaction();
		dbSession.update(user);
		hibernateUtil.commitTransaction(dbSession);
	}
	
}
