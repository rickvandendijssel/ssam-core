package com.ssam.core.authentication.datafilter;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.ssam.core.main.AbstractDataFilter;

public class GroupDataFilter extends AbstractDataFilter {
	
	private Long groupID;
	
	public Long getGroupID() {
		return groupID;
	}
	public void setGroupID(Long groupID) {
		this.groupID = groupID;
	}

	@Override
	public void setFilter(Criteria criteria) {
		super.setFilter(criteria);
		if(groupID != null){
			criteria.add(Restrictions.eq("groupID", groupID));
		}
	}

}
