package com.example.hibernateclass.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	
	private static SessionFactory sessionFactory;
	
	static {
		
		try {
			if(sessionFactory==null) {
				sessionFactory= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			}
		}catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Error in creating session factory"+e.getMessage());
		}
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}

