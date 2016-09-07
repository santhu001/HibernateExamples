package com.hibernate.relations.many2many;

import org.hibernate.Session;

import com.santhu.persistance.HibernateUtil;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Session session= HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    Meeting meeting1 = new Meeting("Quaterly Sales meeting");
    Meeting meeting2 = new Meeting("Weekly Status meeting");
    
    Employee employee1 = new Employee("santhosh", "erukala");
    Employee employee2 = new Employee("Kranthi", "Pasala");

    employee1.getMeetings().add(meeting1);
    employee1.getMeetings().add(meeting2);
    employee2.getMeetings().add(meeting1);
    
    session.save(employee1);
    session.save(employee2);
    
    session.getTransaction().commit();
    session.close();
    HibernateUtil.shutdown();
	}

}
