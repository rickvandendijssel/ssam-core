package com.ssam.core.config.datafilter;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.ssam.core.main.AbstractDataFilter;

public class CorePropertyListDataFilter extends AbstractDataFilter {
	
	private String likeValue;

	public String getLikeValue() {
		return likeValue;
	}

	public void setLikeValue(String likeValue) {
		this.likeValue = likeValue;
	}
	
	@Override
	public void setFilter(Criteria criteria) {
		super.setFilter(criteria);
		if(likeValue != null){
			criteria.add(Restrictions.like("value", likeValue,MatchMode.ANYWHERE));
		}
	}

}
