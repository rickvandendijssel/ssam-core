package com.ssam.core.authentication.datafilter;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.ssam.core.main.AbstractDataFilter;

public class UserDataFilter extends AbstractDataFilter {
	
	private Long userID;
	private String email;
	
	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public void setFilter(Criteria criteria) {
		super.setFilter(criteria);
		if(userID != null){
			criteria.add(Restrictions.eq("userID", userID));
		}
		if(email != null){
			criteria.add(Restrictions.eq("email", email));
		}

	}

}
