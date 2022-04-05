package com.test;

import org.hibernate.Session;

import com.Util.HibernateUtil;
import com.instructor.Instructor;
import com.instructor.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		System.out.println("Getting the Instructor");

		Instructor inst = session.get(Instructor.class, 1);
		
		System.out.println("Instructor: "+inst);
		
		System.out.println("Courses: "+inst.getCourse());
		
		
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
		System.out.println("Done!");
	}

}
