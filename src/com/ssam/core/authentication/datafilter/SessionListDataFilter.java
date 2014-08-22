package com.ssam.core.authentication.datafilter;

import java.util.Date;

import org.hibernate.Criteria;

import com.ssam.core.main.AbstractDataFilter;

public class SessionListDataFilter extends AbstractDataFilter {
	
	private Date beforeDate;
	private Date afterDate;
	
	public Date getBeforeDate() {
		return beforeDate;
	}
	public void setBeforeDate(Date beforeDate) {
		this.beforeDate = beforeDate;
	}
	public Date getAfterDate() {
		return afterDate;
	}
	public void setAfterDate(Date afterDate) {
		this.afterDate = afterDate;
	}

	@Override
	public void setFilter(Criteria criteria) {
		super.setFilter(criteria);

	}

}
