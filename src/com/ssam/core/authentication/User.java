package com.ssam.core.authentication;

import java.util.List;

import com.ssam.core.config.Country;
import com.ssam.core.config.Language;

public class User {
	
	/*
	 * All the primaire data from POJO User
	 */
	private Long userID;
	private String email;
	private String password;
	private UserType type;
	private String firstName;
	private String middleName;
	private String lastName;
	private String zipcode;
	private String address;
	private String houseNumber;
	private Long phoneNumber;
	private String residence;
	private Country country;
	private Language language;
	private Boolean active;
	
	/*
	 * All the collections from POJO User
	 */
	private List<String> notificationEmailList;
	private List<Group> groupList;
	private List<String> secureToken;
	private List<Session> sessionList;
	
	/*
	 * All the set and get function from POJO User
	 */
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
	
	public UserType getType() {
		return type;
	}
	
	public void setType(UserType type) {
		this.type = type;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getResidence() {
		return residence;
	}
	public void setResidence(String residence) {
		this.residence = residence;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public List<String> getNotificationEmailList() {
		return notificationEmailList;
	}
	public void setNotificationEmailList(List<String> notificationEmailList) {
		this.notificationEmailList = notificationEmailList;
	}
	public List<Group> getGroupList() {
		return groupList;
	}
	public void setGroupList(List<Group> groupList) {
		this.groupList = groupList;
	}
	public List<String> getSecureToken() {
		return secureToken;
	}
	public void setSecureToken(List<String> secureToken) {
		this.secureToken = secureToken;
	}
	public List<Session> getSessionList() {
		return sessionList;
	}
	public void setSessionList(List<Session> sessionList) {
		this.sessionList = sessionList;
	}
	
}
