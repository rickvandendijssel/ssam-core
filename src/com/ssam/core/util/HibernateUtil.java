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
	
	private Session session;
	
	public HibernateUtil(){
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	public void createNewSession(){
		session = sessionFactory.openSession();
		session.setFlushMode(FlushMode.MANUAL);
		ManagedSessionContext.bind(session);
	}
	
	public void startNewTransaction(){
		session.beginTransaction();
	}
	
	public void commitTransaction(){
		ManagedSessionContext.unbind(sessionFactory);
		session.flush();
		session.getTransaction().commit();
	}
	
	public void closeSession(){
		session.close();
	}
	
	public Session getSession(){
		return this.session;
	}
	
	
}
