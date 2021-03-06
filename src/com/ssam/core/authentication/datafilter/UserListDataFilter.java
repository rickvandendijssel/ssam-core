package com.ssam.core.authentication.datafilter;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.ssam.core.config.Country;
import com.ssam.core.main.AbstractDataFilter;

public class UserListDataFilter extends AbstractDataFilter {
	
	private String likeFirstName;
	private String likeMiddleName;
	private String likeLastName;
	private String likeEmail;
	private String likeZipcode;
	private String likeAddress;
	private String likeHouseNumber;
	private String likePhoneNumber;
	private String likeResidence;
	private Country country;

	public String getLikeFirstName() {
		return likeFirstName;
	}

	public void setLikeFirstName(String likeFirstName) {
		this.likeFirstName = likeFirstName;
	}

	public String getLikeMiddleName() {
		return likeMiddleName;
	}

	public void setLikeMiddleName(String likeMiddleName) {
		this.likeMiddleName = likeMiddleName;
	}

	public String getLikeLastName() {
		return likeLastName;
	}

	public void setLikeLastName(String likeLastName) {
		this.likeLastName = likeLastName;
	}

	public String getLikeEmail() {
		return likeEmail;
	}

	public void setLikeEmail(String likeEmail) {
		this.likeEmail = likeEmail;
	}

	public String getLikeZipcode() {
		return likeZipcode;
	}

	public void setLikeZipcode(String likeZipcode) {
		this.likeZipcode = likeZipcode;
	}

	public String getLikeAddress() {
		return likeAddress;
	}

	public void setLikeAddress(String likeAddress) {
		this.likeAddress = likeAddress;
	}

	public String getLikeHouseNumber() {
		return likeHouseNumber;
	}

	public void setLikeHouseNumber(String likeHouseNumber) {
		this.likeHouseNumber = likeHouseNumber;
	}

	public String getLikePhoneNumber() {
		return likePhoneNumber;
	}

	public void setLikePhoneNumber(String likePhoneNumber) {
		this.likePhoneNumber = likePhoneNumber;
	}

	public String getLikeResidence() {
		return likeResidence;
	}

	public void setLikeResidence(String likeResidence) {
		this.likeResidence = likeResidence;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public void setFilter(Criteria criteria) {
		super.setFilter(criteria);
		if(likeFirstName != null){
			criteria.add(Restrictions.like("firstName", likeFirstName, MatchMode.ANYWHERE));
		}
		if(likeMiddleName != null){
			criteria.add(Restrictions.like("middleName", likeMiddleName, MatchMode.ANYWHERE));
		}
		if(likeLastName != null){
			criteria.add(Restrictions.like("lastName", likeLastName, MatchMode.ANYWHERE));
		}
		if(likeEmail != null){
			criteria.add(Restrictions.like("email", likeEmail, MatchMode.ANYWHERE));
		}
		if(likeZipcode != null){
			criteria.add(Restrictions.like("zipcode", likeZipcode, MatchMode.ANYWHERE));
		}
		if(likeAddress != null){
			criteria.add(Restrictions.like("address", likeAddress, MatchMode.ANYWHERE));
		}
		if(likeHouseNumber != null){
			criteria.add(Restrictions.like("houseNumber", likeHouseNumber, MatchMode.ANYWHERE));
		}
		if(likePhoneNumber != null){
			criteria.add(Restrictions.like("phoneNumber", likePhoneNumber, MatchMode.ANYWHERE));
		}
		if(likeResidence != null){
			criteria.add(Restrictions.like("residence", likeResidence, MatchMode.ANYWHERE));
		}
		if(country != null){
			criteria.add(Restrictions.eq("country", country));
		}
	}

}
