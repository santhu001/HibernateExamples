package com.santhu;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.santhu.persistance.HibernateUtil;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory fctory=HibernateUtil.getSessionFactory();
		Session session=fctory.openSession();
		
		Criteria criteria=session.createCriteria(Employee.class);
		List<Employee> ls=criteria.list();
		for (Employee employee : ls) {
			System.out.println(employee.getName());
	}
		HibernateUtil.shutdown();
}
}
