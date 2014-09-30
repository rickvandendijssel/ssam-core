package com.ssam.core.authentication;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.jboss.logging.Logger;

import com.ssam.core.authentication.datafilter.SessionDataFilter;
import com.ssam.core.authentication.datafilter.SessionListDataFilter;
import com.ssam.core.config.CoreProperty;
import com.ssam.core.config.CorePropertyKey;
import com.ssam.core.config.CorePropertyManager;
import com.ssam.core.config.datafilter.CorePropertyDataFilter;
import com.ssam.core.main.AbstractManager;
import com.ssam.core.main.CoreFactory;
import com.ssam.core.util.HibernateUtil;

public class SessionManager extends AbstractManager  {
	
	private HibernateUtil hibernateUtil = CoreFactory.getCoreFactory().getHibernateUtil();
	Logger logger = Logger.getLogger(this.getClass());
	
	public List<Session> getSessionList(SessionListDataFilter filter){
		org.hibernate.Session dbSession = hibernateUtil.getSession();
		hibernateUtil.startNewTransaction();
		Criteria criteria = dbSession.createCriteria(Session.class);
		filter.setFilter(criteria);
		@SuppressWarnings("unchecked")
		List<Session> result = (List<Session>) criteria.list();
		hibernateUtil.commitTransaction();
		return result;
	}
	
	public Long addSession(Session session){
		org.hibernate.Session dbSession = hibernateUtil.getSession();
		hibernateUtil.startNewTransaction();		
		Long sessionID = (Long) dbSession.save(session);
		CoreFactory.getCoreFactory().getHibernateUtil().commitTransaction();
		return sessionID;
	}
	
	public Session getSession(SessionDataFilter filter){
		org.hibernate.Session dbSession = hibernateUtil.getSession();
		hibernateUtil.startNewTransaction();
		Criteria criteria = dbSession.createCriteria(Session.class);
		filter.setFilter(criteria);
		Session session = (Session)criteria.uniqueResult();
		hibernateUtil.commitTransaction();
		return session;
	}
	
	public void deleteSession(Session session){
		org.hibernate.Session dbSession = hibernateUtil.getSession();
		hibernateUtil.startNewTransaction();
		dbSession.delete(session);
		hibernateUtil.commitTransaction();
	}
	
	public void updateSession(Session session){
		org.hibernate.Session dbSession = hibernateUtil.getSession();
		hibernateUtil.startNewTransaction();
		dbSession.update(session);
		hibernateUtil.commitTransaction();
	}
	
	public void deleteExpiredSession(){
		org.hibernate.Session dbSession = hibernateUtil.getSession();
		CorePropertyManager corePropertyManager = new CorePropertyManager();
		CorePropertyDataFilter filter = new CorePropertyDataFilter();
		filter.setKey(CorePropertyKey.SESSIONEXPIRETIME);
		CoreProperty expire = corePropertyManager.getCoreProperty(filter);
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		Integer expireTime =  Integer.valueOf(expire.getValue());
		expireTime	*= -1;
		cal.add(Calendar.MINUTE, expireTime);
		hibernateUtil.startNewTransaction();
		Query query = dbSession.createQuery("delete from Session where lastActivity < :expires");
		query.setParameter("expires", cal.getTime());
		query.executeUpdate();
		hibernateUtil.commitTransaction();
	}
}
