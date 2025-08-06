package com.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.test.model.Employee;

public class HQLPagination {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		
		Query query = s.createQuery("from Employee");
		
		//Implementing pagination using hibernate
		
		query.setFirstResult(0);
		
		query.setMaxResults(5);
		
		List<Employee> list = query.list();
		
		for (Employee em : list) {
			System.out.println(em.getId()+" : "+em.getName() + " : "+em.getCity());
		}
		
		s.close();
		factory.close();
	}
}
