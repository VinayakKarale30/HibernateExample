package com.save.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.test.model.Certificate;
import com.test.model.Employee;

public class EmbeddedDemo {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Employee employee1 = new Employee();
		employee1.setId(107);
		employee1.setName("Rahul Jaikar");
		employee1.setCity("Banglore");
		
		Certificate certificate = new Certificate();
		certificate.setCourse("Android");
		certificate.setDuration("2 Months");
		
		employee1.setCerti(certificate);
		
		Employee employee2 = new Employee();
		employee2.setId(108);
		employee2.setName("Arjun Bansal");
		employee2.setCity("Chennai");
		
		Certificate certificate1 = new Certificate();
		certificate1.setCourse("Java");
		certificate1.setDuration("3 Months");
		
		employee2.setCerti(certificate1);
		
		Session s =factory.openSession();
		Transaction tx=s.beginTransaction();
		
		s.save(employee1);
		s.save(employee2);
		
		
		tx.commit();
		s.close();
		factory.close();
	}
}
