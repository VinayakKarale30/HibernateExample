package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		//creating question
		Question q1=new Question();
		q1.setQuestionId(101);
		q1.setQuestion("What is Java?");
		
		//creating answer
		
		Answer answer=new Answer();
		answer.setAnswerId(201);
		answer.setAnswer("Java is programming language.");
		answer.setQuestion(q1);
		
		Answer answer1=new Answer();
		answer1.setAnswerId(301);
		answer1.setAnswer("We can create softwares");
		answer1.setQuestion(q1);
		
		Answer answer2=new Answer();
		answer2.setAnswerId(401);
		answer2.setAnswer("It is object based language");
		answer2.setQuestion(q1);
		
		List<Answer> list =new ArrayList<Answer>();
		list.add(answer);
		list.add(answer1);
		list.add(answer2);
		q1.setAnswers(list);
		
		
		//Session
		
		Session s=factory.openSession();
		
		Transaction tx=s.beginTransaction();
		
		//Save
		s.save(q1);
		s.save(answer);
		s.save(answer1);
		s.save(answer2);
		
		
		tx.commit();
		
		s.close();
		
		
		factory.close();
	}
}
