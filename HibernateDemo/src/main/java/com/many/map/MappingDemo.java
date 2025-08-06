package com.many.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		
		Empl e1=new Empl();
		Empl e2=new Empl();
		
		e1.setEid(51);
		e1.setName("Rohan");
		
		e2.setEid(52);
		e2.setName("Ramesh");
		
		Project p1=new Project();
		Project p2=new Project();
		
		p1.setPid(101);
		p1.setProjectName("ERP Management");
		
		p2.setPid(102);
		p2.setProjectName("Inventory Management");
		
		List<Empl> list1=new ArrayList<Empl>();
		List<Project> list2=new ArrayList<Project>();
		
		list1.add(e1);
		list1.add(e2);
		
		list2.add(p1);
		list2.add(p2);
		
		
		e1.setProjects(list2);
		p2.setEmps(list1);
		
		Session s=factory.openSession();
		Transaction tx=s.beginTransaction();
		
		s.save(e1);
		s.save(e2);
		s.save(p1);
		s.save(p2);
		
		
		tx.commit();
		s.close();
		
		
		factory.close();
		
	}
	
}
