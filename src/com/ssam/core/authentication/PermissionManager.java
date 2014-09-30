package com.ssam.core.authentication;

import java.util.List;

import org.hibernate.Criteria;

import com.ssam.core.authentication.datafilter.PermissionListDataFilter;
import com.ssam.core.main.AbstractManager;
import com.ssam.core.main.CoreFactory;
import com.ssam.core.util.HibernateUtil;

public class PermissionManager extends AbstractManager {
	
	private HibernateUtil hibernateUtil = CoreFactory.getCoreFactory().getHibernateUtil();
	
	public List<Permission> getPermissionList(PermissionListDataFilter filter){
		org.hibernate.Session dbSession = hibernateUtil.getSession();
		hibernateUtil.startNewTransaction();
		Criteria criteria = dbSession.createCriteria(Permission.class);
		filter.setFilter(criteria);
		@SuppressWarnings("unchecked")
		List<Permission> result = (List<Permission>) criteria.list();
		hibernateUtil.commitTransaction();
		return result;
	}

}
