package com.ssam.core.config;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.ssam.core.config.datafilter.CorePropertyDataFilter;
import com.ssam.core.config.datafilter.CorePropertyListDataFilter;
import com.ssam.core.main.AbstractManager;
import com.ssam.core.main.CoreFactory;
import com.ssam.core.util.HibernateUtil;

public class CorePropertyManager extends AbstractManager {

	private HibernateUtil hibernateUtil = CoreFactory.getCoreFactory().getHibernateUtil();
	
	public List<CoreProperty> getCorePropertyList(CorePropertyListDataFilter filter){
		Session dbSession = hibernateUtil.getSession();
		hibernateUtil.startNewTransaction();
		Criteria criteria = dbSession.createCriteria(CoreProperty.class);
		filter.setFilter(criteria);
		@SuppressWarnings("unchecked")
		List<CoreProperty> result = (List<CoreProperty>) criteria.list();
		hibernateUtil.commitTransaction();
		return result;
	}
	
	public CoreProperty getCoreProperty(CorePropertyDataFilter filter){
		Session dbSession = hibernateUtil.getSession();
		hibernateUtil.startNewTransaction();
		Criteria criteria = dbSession.createCriteria(CoreProperty.class);
		filter.setFilter(criteria);
		CoreProperty result = (CoreProperty) criteria.uniqueResult();
		hibernateUtil.commitTransaction();
		return result;
	}
	
}
