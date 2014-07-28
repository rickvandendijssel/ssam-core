package com.ssam.core.util;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ManagedSessionContext;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private SessionFactory sessionFactory;
	
	public HibernateUtil(){
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	private Session createNewSession(){
		Session session = sessionFactory.openSession();
		session.setFlushMode(FlushMode.MANUAL);
		ManagedSessionContext.bind(session);
		return session;
	}
	
	private void startNewTransaction(Session session){
		session.beginTransaction();
	}
	
	public Session createNewSessionAndStartTransaction(){
		Session session = createNewSession();
		startNewTransaction(session);
		return session;
	}
	
	public void commitTransaction(Session session){
		ManagedSessionContext.unbind(sessionFactory);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	
	
}
