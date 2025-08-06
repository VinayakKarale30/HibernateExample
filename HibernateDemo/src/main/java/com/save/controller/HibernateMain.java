package com.save.controller;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.test.main.HibernateUtil;
import com.test.model.Address;
import com.test.model.Employee;

public class HibernateMain {

	public static void main(String[] args) {
		
		
		
		Employee em=new Employee();
		em.setId(104);
		em.setName("Sagar");
		em.setCity("Mumbai");
		
		System.out.println(em);
		
		Address ad=new Address();
		ad.setStreet("63' Street");
		ad.setCity("Banaras");
		ad.setOpen(true);
		ad.setAddedDate(new Date());
		ad.setX(1234.12);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tx=session.beginTransaction();
		
		session.save(em);
		session.save(ad);
		
		tx.commit();
		
		session.close();
	
	}
	
}
