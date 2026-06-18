package com.abc.demo.FirstHibernateProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.abc.demo.FirstHibernateProject.BookEntity;


public class InsertBookDetails {

	public static void main(String[] args) {
		
		BookEntity b1 = new BookEntity();
		b1.setBookId(12);
		b1.setBookTitle("Java Programming!");
		b1.setBookPrice(400);
		
		
		BookEntity b2 = new BookEntity();
		b2.setBookId(13);
		b2.setBookTitle("Python Programming!");
		b2.setBookPrice(300);
		
		
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		
		SessionFactory factory = 
				config.buildSessionFactory();
		
		Session session = factory.openSession();//vehicle
		
		Transaction t = session.beginTransaction();
		session.persist(b1);
		session.persist(b2);
		t.commit();
		
		

	}

}