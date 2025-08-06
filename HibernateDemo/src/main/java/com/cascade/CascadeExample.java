package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.Answer;
import com.map.Question;

public class CascadeExample {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		
		Question q1=new Question();
		
		q1.setQuestionId(540);
		q1.setQuestion("What is cascading?");
		
		Answer a1 = new Answer(876, "This is First answer!");
		Answer a2 = new Answer(886, "This is Second answer!");
		Answer a3 = new Answer(898, "This is Third answer!");
		
		
		a1.setQuestion(q1);  
		a2.setQuestion(q1);
		a3.setQuestion(q1);
		
		List<Answer> list = new ArrayList<>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		q1.setAnswers(list);
		
		Transaction tx = s.beginTransaction();
		
		s.save(q1);
		
		tx.commit();
		s.close();
		factory.close();
	}
}
