package com.ssam.core.main;


import java.util.Locale;

import com.ssam.core.util.HibernateUtil;

public class CoreFactory {
	
	private static CoreFactory coreFactory;
	
	private HibernateUtil hibernateUtil;
	
	private Locale locale;
	
	private CoreFactory(){
		hibernateUtil = new HibernateUtil();
		//default language = Engels
		locale = new Locale("en");
	}
	
	public static CoreFactory getCoreFactory(){
		if(coreFactory == null){
			coreFactory = new CoreFactory();
		}
		return coreFactory;
	}
	
	public HibernateUtil getHibernateUtil(){
	    return hibernateUtil;
	}
	
	public void setLocale(Locale locale){
		this.locale = locale;
	}
	
	public Locale getLocale(){
		return locale;
	}

}
