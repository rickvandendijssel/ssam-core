package com.ssam.core.authentication;

import java.util.List;

public class Permission {
	
	/*
	 * All the primaire data from POJO Permission
	 */
	private Long permissionID;
	private PermissionType permissionType;
	
	/*
	 * All the collections from POJO Permission
	 */
	private List<Group> groupList;

	public Long getPermissionID() {
		return permissionID;
	}

	public void setPermissionID(Long permissionID) {
		this.permissionID = permissionID;
	}

	public PermissionType getPermissionType() {
		return permissionType;
	}

	public void setPermissionType(PermissionType permissionType) {
		this.permissionType = permissionType;
	}

	public List<Group> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<Group> groupList) {
		this.groupList = groupList;
	}
}
