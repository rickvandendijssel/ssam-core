package com.ssam.core.authentication;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

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
	
	public List<Group> getGroupList(GroupListFilter groupListFilter){
		org.hibernate.Session dbSession = hibernateUtil.createNewSessionAndStartTransaction();
		Criteria criteria = dbSession.createCriteria(Group.class);
		if(groupListFilter.getLikeName()!= null){
			criteria.add(Restrictions.like("NAME", groupListFilter.getLikeName()));
		}
		@SuppressWarnings("unchecked")
		List<Group> result = (List<Group>) criteria.list();
		hibernateUtil.commitTransaction(dbSession);
		return result;
	}
	
	public Group getGroup(GroupFilter groupFilter){
		org.hibernate.Session dbSession = hibernateUtil.createNewSessionAndStartTransaction();
		Criteria criteria = dbSession.createCriteria(Group.class);
		if(groupFilter.getId() != null){
			criteria.add(Restrictions.eq("GROUPID", groupFilter.getId()));
		}
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
	
	public class GroupListFilter{
		private String likeName;

		public String getLikeName() {
			return likeName;
		}
		public void setLikeName(String likeName) {
			this.likeName = likeName;
		}
	}
	
	public class GroupFilter{
		private Long id;
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
	}

}
