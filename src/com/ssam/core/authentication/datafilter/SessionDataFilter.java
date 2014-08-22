package com.ssam.core.authentication.datafilter;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.ssam.core.main.AbstractDataFilter;

public class SessionDataFilter extends AbstractDataFilter {
	
	private String token;
	private Long sessionID;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	public Long getSessionID() {
		return sessionID;
	}

	public void setSessionID(Long sessionID) {
		this.sessionID = sessionID;
	}

	@Override
	public void setFilter(Criteria criteria) {
		super.setFilter(criteria);
		if(token != null){
			criteria.add(Restrictions.eq("token", token));
		}
		if(sessionID != null){
			criteria.add(Restrictions.eq("sessionID", sessionID));
		}
	}

}
