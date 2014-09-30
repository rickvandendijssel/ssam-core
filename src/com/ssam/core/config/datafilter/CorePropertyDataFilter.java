package com.ssam.core.config.datafilter;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.ssam.core.config.CorePropertyKey;
import com.ssam.core.main.AbstractDataFilter;

public class CorePropertyDataFilter extends AbstractDataFilter {
	
	private CorePropertyKey key;

	public CorePropertyKey getKey() {
		return key;
	}

	public void setKey(CorePropertyKey key) {
		this.key = key;
	}
	
	@Override
	public void setFilter(Criteria criteria) {
		super.setFilter(criteria);
		if(key != null){
			criteria.add(Restrictions.eq("key", key));
		}
	}

}
