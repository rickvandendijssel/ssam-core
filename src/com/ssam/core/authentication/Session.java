package com.ssam.core.authentication;

import java.util.Date;

import com.ssam.core.config.Language;

public class Session {
	
	private Long sessionID;
	
	private String token;
	
	private String ip;
	
	private Date lastActivity;
	
	private Language language;

	private User user;
	
	public Long getSessionID() {
		return sessionID;
	}
	public void setSessionID(Long sessionID) {
		this.sessionID = sessionID;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getLastActivity() {
		return lastActivity;
	}
	public void setLastActivity(Date lastActivity) {
		this.lastActivity = lastActivity;
	}
	
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
