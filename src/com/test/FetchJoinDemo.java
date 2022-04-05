package com.test;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.Util.HibernateUtil;
import com.instructor.Instructor;

public class FetchJoinDemo {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		int theId = 1;
		System.out.println("Getting data with HQL");
		// DID NOT WORK
		Query<Instructor> query = 
				session.createQuery("select i from Instructor i "
								+ "JOIN FETCH i.courses "
								+ "where i.id=:theInstructorId", 
								Instructor.class);
		
		// set parameter on query
		query.setParameter("theInstructorId", theId);
		
		// execute query and get instructor
		Instructor tempInstructor = query.getSingleResult();
		
		System.out.println("luv2code: Instructor: " + tempInstructor);	
		
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
		System.out.println("Done!");
	}

}
