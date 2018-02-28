package com.hibernate;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			System.out.println("Creating new student object...");
			Student tempStudent = new Student("Paul", "Doe", "paul@gmail.com");
			
			
			session.beginTransaction();
			
			
			System.out.println("Saving the student...");
			session.save(tempStudent);
			
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}





