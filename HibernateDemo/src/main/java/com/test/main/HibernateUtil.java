package com.test.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;	
    
    static {
    	try {
			
    		sessionFactory = new Configuration().configure().buildSessionFactory();
		} 
    	
    	catch (Exception e) {
			System.err.println("SessionFactory creation failed: "+e);
			throw new ExceptionInInitializerError(e);
		}
    }
    
    public static SessionFactory getSessionFactory() {
    	return sessionFactory; 
    	
    }
    
    public static void shutdown() {
		if(sessionFactory!=null) {
			sessionFactory.close();
		}
	}
    

}
