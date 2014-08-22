package com.ssam.core.authentication.datafilter;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.ssam.core.main.AbstractDataFilter;

public class GroupListDataFilter extends AbstractDataFilter {

	private String likeName;

	public String getLikeName() {
		return likeName;
	}
	public void setLikeName(String likeName) {
		this.likeName = likeName;
	}
	
	@Override
	public void setFilter(Criteria criteria) {
		super.setFilter(criteria);
		if(likeName != null){
			criteria.add(Restrictions.like("name", likeName));
		}
	}

}
