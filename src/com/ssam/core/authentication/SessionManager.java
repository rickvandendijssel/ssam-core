package com.ssam.core.authentication;

import java.util.List;

import org.hibernate.Criteria;

import com.ssam.core.authentication.datafilter.SessionDataFilter;
import com.ssam.core.authentication.datafilter.SessionListDataFilter;
import com.ssam.core.main.CoreFactory;
import com.ssam.core.util.HibernateUtil;

public class SessionManager {
	
	private HibernateUtil hibernateUtil = CoreFactory.getCoreFactory().getHibernateUtil();
	
	public List<Session> getSessionList(SessionListDataFilter filter){
		org.hibernate.Session dbSession = hibernateUtil.createNewSessionAndStartTransaction();
		Criteria criteria = dbSession.createCriteria(Session.class);
		filter.setFilter(criteria);
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
	
	public Session getSession(SessionDataFilter filter){
		org.hibernate.Session dbSession = hibernateUtil.createNewSessionAndStartTransaction();
		Criteria criteria = dbSession.createCriteria(Session.class);
		filter.setFilter(criteria);
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
