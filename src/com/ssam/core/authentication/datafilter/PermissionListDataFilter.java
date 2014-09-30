package com.ssam.core.authentication.datafilter;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.ssam.core.main.AbstractDataFilter;

public class PermissionListDataFilter extends AbstractDataFilter  {
	private Long userID;
	private String type;
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public void setFilter(Criteria criteria) {
		super.setFilter(criteria);
		if(type != null){
			criteria.add(Restrictions.like("permissionType", type,MatchMode.ANYWHERE));
		}
		if(userID != null){
			criteria.createAlias("groupList", "group");
			criteria.createAlias("group.userList", "user");
			criteria.add(Restrictions.eq("user.userID", userID));
		}
	}
}
