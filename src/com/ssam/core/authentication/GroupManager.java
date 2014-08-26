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
		org.hibernate.Session dbSession = hibernateUtil.getSession();
		hibernateUtil.startNewTransaction();
		Criteria criteria = dbSession.createCriteria(Group.class);
		@SuppressWarnings("unchecked")
		List<Group> result = (List<Group>) criteria.list();
		hibernateUtil.commitTransaction();
		return result;
	}
	
	public List<Group> getGroupList(GroupListDataFilter filter){
		org.hibernate.Session dbSession = hibernateUtil.getSession();
		hibernateUtil.startNewTransaction();
		Criteria criteria = dbSession.createCriteria(Group.class);
		filter.setFilter(criteria);
		@SuppressWarnings("unchecked")
		List<Group> result = (List<Group>) criteria.list();
		hibernateUtil.commitTransaction();
		return result;
	}
	
	public Group getGroup(GroupDataFilter filter){
		org.hibernate.Session dbSession = hibernateUtil.getSession();
		hibernateUtil.startNewTransaction();
		Criteria criteria = dbSession.createCriteria(Group.class);
		filter.setFilter(criteria);
		Group result = (Group) criteria.uniqueResult();
		hibernateUtil.commitTransaction();
		return result;
	}
	
	public Long addGroup(Group group){
		org.hibernate.Session dbSession = hibernateUtil.getSession();
		hibernateUtil.startNewTransaction();
		Long groupID = (Long)dbSession.save(group);
		hibernateUtil.commitTransaction();
		return groupID;
	}
	
	public void updateGroup(Group group){
		org.hibernate.Session dbSession = hibernateUtil.getSession();
		hibernateUtil.startNewTransaction();
		dbSession.update(group);
		hibernateUtil.commitTransaction();
	}
	
	public void deleteGroup(Group group){
		org.hibernate.Session dbSession = hibernateUtil.getSession();
		hibernateUtil.startNewTransaction();
		dbSession.delete(group);
		hibernateUtil.commitTransaction();
	}
	
}
