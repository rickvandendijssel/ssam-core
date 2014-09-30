package com.ssam.core.authentication.datacheck;

import com.ssam.core.authentication.User;
import com.ssam.core.main.AbstractDataCheck;
import com.ssam.core.main.DataCheck;

public class UserDataCheck extends AbstractDataCheck implements DataCheck {
	
	private User user;
	
	public UserDataCheck(User user){
		this.user = user;
	}

	@Override
	public Boolean check() {
		Boolean check = true;
		if(user.getZipcode().length() != 6){
			error+= "Zipcode needs to be like 1111AA";
			check = false;
		}
		return check;
	}
}
