package com.ssam.core.authentication;

public class UserExtData {
	
	/*
	 * All the primaire data from POJO UserExtData
	 */
	private Long extDataID;
	private String key;
	private String value;
	
	/*
	 * All the set and get function from POJO UserGroup
	 */
	public Long getExtDataID() {
		return extDataID;
	}
	public void setExtDataID(Long extDataID) {
		this.extDataID = extDataID;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

}
