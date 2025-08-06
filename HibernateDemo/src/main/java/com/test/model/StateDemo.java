package com.test.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {

	public static void main(String[] args) {
		
		
		
		SessionFactory f= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		//Creating Employee object:
		
		Employee employee=new Employee();
		employee.setId(11);
		employee.setName("Alex");
		employee.setCity("Las Vegas");
		employee.setCerti(new Certificate("Java Hibernate","2 Months"));
		//Employee: Transient state
		
		Session s=f.openSession();
		Transaction tx=s.beginTransaction();
		s.save(employee);
		//Employee: Persistent state - (session, Database)
		
		employee.setName("Joy");
		
		tx.commit();
		
		s.close();
		//Employee: Detached state
		
		employee.setName("Alena");     //New value will not change due to object is in detached state. ex.Alena
		
		f.close();
	}
	
}
