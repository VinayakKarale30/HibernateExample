package com.hql;


import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.test.model.Employee;

public class HQLExample {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session s = factory.openSession();
		
		String query="from Employee where city= 'Banglore'";
		
		Query q = s.createQuery(query);
		
		List<Employee> list = q.list();
		
		
		for (Employee employee : list) 
		{
			System.out.println(employee.getName()+ ":"+employee.getCerti().getCourse());
			
		}
		
		Transaction tx=s.beginTransaction();
		
		//Delete Query
		//Query q2 = s.createQuery("delete from Employee e where e.city=:c");
		//q2.setParameter("c", "Chennai");
		//int r = q2.executeUpdate();
		//System.out.println("Deleted:");
		//System.out.println(r);
		
		Query q2 = s.createQuery("update Employee set city=:c where name=:n");
		q2.setParameter("c", "Delhi");
		q2.setParameter("n", "Arjun Bansal");
	    int r = q2.executeUpdate();
	    System.out.println(r + "Objects updated");
		
		tx.commit();
		
		//How to execute join query
		Query q3=s.createQuery("select q.question, q.questionId, a.answer from Question as q INNER JOIN q.answers as a ");
		
		List<Object []> list3=q3.getResultList();
		
		for (Object[] arr : list3) 
		{
			System.out.println(Arrays.toString(arr));
		}
		
		s.close();
		factory.close();
		
	}
}
