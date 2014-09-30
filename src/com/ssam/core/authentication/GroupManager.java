package com.ssam.core.authentication;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;

import com.ssam.core.authentication.datafilter.GroupDataFilter;
import com.ssam.core.authentication.datafilter.GroupListDataFilter;
import com.ssam.core.main.AbstractManager;
import com.ssam.core.main.CoreFactory;
import com.ssam.core.util.HibernateUtil;

public class GroupManager extends AbstractManager  {
	
	private HibernateUtil hibernateUtil = CoreFactory.getCoreFactory().getHibernateUtil();
	
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
	
	public Long addGroup(Group group, List<Long> PermissionIDList){
		org.hibernate.Session dbSession = hibernateUtil.getSession();
		hibernateUtil.startNewTransaction();
		for(Long PermissionID : PermissionIDList){
			Permission permission = (Permission) dbSession.load(Permission.class, PermissionID);
			group.getPermissionList().add(permission);
		}
		Long groupID = (Long)dbSession.save(group);
		hibernateUtil.commitTransaction();
		return groupID;
	}
	
	public void updateGroup(Group group, List<Long> PermissionIDList){
		org.hibernate.Session dbSession = hibernateUtil.getSession();
		hibernateUtil.startNewTransaction();
		if(PermissionIDList != null){
			group.setPermissionList(new ArrayList<Permission>());
			for(Long PermissionID : PermissionIDList){
				Permission permission = (Permission) dbSession.load(Permission.class, PermissionID);
				group.getPermissionList().add(permission);
			}
		}
		dbSession.update(group);
		hibernateUtil.commitTransaction();
	}
	
	public Boolean deleteGroup(Long groupID){
		org.hibernate.Session dbSession = hibernateUtil.getSession();
		hibernateUtil.startNewTransaction();
		Group group = (Group)dbSession.load(Group.class, groupID);
		if(group.getUserList().size() < 1){
			dbSession.delete(group);
			hibernateUtil.commitTransaction();
			return true;
		}
		this.error = "Group still has users they need to be removed first";
		hibernateUtil.commitTransaction();
		return false;

	}
	
}
