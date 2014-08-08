package com.ssam.core.authentication;

import java.util.List;

import org.hibernate.Criteria;

import com.ssam.core.authentication.datafilter.GroupDataFilter;
import com.ssam.core.authentication.datafilter.GroupListDataFilter;
import com.ssam.core.main.CoreFactory;
import com.ssam.core.util.HibernateUtil;

public class GroupManager {
	
	private HibernateUtil hibernateUtil = CoreFactory.getCoreFactory().getHibernateUtil();
	
	public List<Group> getGroupList(){
		org.hibernate.Session dbSession = hibernateUtil.createNewSessionAndStartTransaction();
		Criteria criteria = dbSession.createCriteria(Group.class);
		@SuppressWarnings("unchecked")
		List<Group> result = (List<Group>) criteria.list();
		hibernateUtil.commitTransaction(dbSession);
		return result;
	}
	
	public List<Group> getGroupList(GroupListDataFilter filter){
		org.hibernate.Session dbSession = hibernateUtil.createNewSessionAndStartTransaction();
		Criteria criteria = dbSession.createCriteria(Group.class);
		filter.setFilter(criteria);
		@SuppressWarnings("unchecked")
		List<Group> result = (List<Group>) criteria.list();
		hibernateUtil.commitTransaction(dbSession);
		return result;
	}
	
	public Group getGroup(GroupDataFilter filter){
		org.hibernate.Session dbSession = hibernateUtil.createNewSessionAndStartTransaction();
		Criteria criteria = dbSession.createCriteria(Group.class);
		filter.setFilter(criteria);
		Group result = (Group) criteria.uniqueResult();
		hibernateUtil.commitTransaction(dbSession);
		return result;
	}
	
	public Long addGroup(Group group){
		org.hibernate.Session dbSession = hibernateUtil.createNewSessionAndStartTransaction();
		Long groupID = (Long)dbSession.save(group);
		hibernateUtil.commitTransaction(dbSession);
		return groupID;
	}
	
	public void updateGroup(Group group){
		org.hibernate.Session dbSession = hibernateUtil.createNewSessionAndStartTransaction();
		dbSession.update(group);
		hibernateUtil.commitTransaction(dbSession);
	}
	
	public void deleteGroup(Group group){
		org.hibernate.Session dbSession = hibernateUtil.createNewSessionAndStartTransaction();
		dbSession.delete(group);
		hibernateUtil.commitTransaction(dbSession);
	}
	
}
