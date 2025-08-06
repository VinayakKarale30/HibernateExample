package com.sqlquery;

import java.lang.annotation.Native;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class SQLExample {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session s=factory.openSession();
				
		//SQL Query
		String q= "select * from my_employee";
		
		NativeQuery nq = s.createSQLQuery(q);
		
		List<Object[]> list = nq.list();
		
		for (Object[] employee : list) {
			System.out.println(Arrays.deepToString(employee));
		}
		
		
		
		s.close();
		factory.close();
	}
}
