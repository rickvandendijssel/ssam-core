package com.ssam.core.authentication;

import java.util.List;

public class Group {
	
	/*
	 * All the primaire data from POJO UserGroup
	 */
	private Long groupID;
	private String name;
	
	/*
	 * All the collections from POJO UserGroup
	 */
	private List<User> userList;
	private List<Permission> permissionList;
	
	/*
	 * All the set and get function from POJO UserGroup
	 */
	public Long getGroupID() {
		return groupID;
	}
	public void setGroupID(Long groupID) {
		this.groupID = groupID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public List<Permission> getPermissionList() {
		return permissionList;
	}
	public void setPermissionList(List<Permission> permissionList) {
		this.permissionList = permissionList;
	}
	
}
