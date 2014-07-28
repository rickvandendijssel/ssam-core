package com.ssam.core.authentication;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.ssam.core.main.CoreFactory;
import com.ssam.core.util.HibernateUtil;

public class SessionManager {
	
	private HibernateUtil hibernateUtil = CoreFactory.getCoreFactory().getHibernateUtil();
	
	public List<Session> getSessionList(){
		org.hibernate.Session dbSession = hibernateUtil.createNewSessionAndStartTransaction();
		Criteria criteria = dbSession.createCriteria(Session.class);
		@SuppressWarnings("unchecked")
		List<Session> result = (List<Session>) criteria.list();
		hibernateUtil.commitTransaction(dbSession);
		return result;
	}
	
	public Long addSession(Session session){
		org.hibernate.Session dbSession = CoreFactory.getCoreFactory().getHibernateUtil().createNewSessionAndStartTransaction();
		Long sessionID = (Long) dbSession.save(session);
		CoreFactory.getCoreFactory().getHibernateUtil().commitTransaction(dbSession);
		return sessionID;
	}
	
	public Session getSessionByToken(String token){
		org.hibernate.Session dbSession = hibernateUtil.createNewSessionAndStartTransaction();
		Criteria criteria = dbSession.createCriteria(Session.class);
		criteria.add(Restrictions.eq("TOKEN", token));
		Session session = (Session)criteria.uniqueResult();
		hibernateUtil.commitTransaction(dbSession);
		return session;
	}
	
	public void deleteSession(Session session){
		org.hibernate.Session dbSession = hibernateUtil.createNewSessionAndStartTransaction();
		dbSession.delete(session);
		hibernateUtil.commitTransaction(dbSession);
	}
	
	public void updateSession(Session session){
		org.hibernate.Session dbSession = hibernateUtil.createNewSessionAndStartTransaction();
		dbSession.update(session);
		hibernateUtil.commitTransaction(dbSession);
	}

}
