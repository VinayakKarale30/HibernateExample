package com.test.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session =factory.openSession();
		
		//Get Employee:104
		
		Employee employee =(Employee)session.get(Employee.class, 104);
		System.out.println(employee);
		
		session.close();
		factory.close();
	}

}
