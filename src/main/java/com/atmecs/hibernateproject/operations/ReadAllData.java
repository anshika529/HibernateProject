package com.atmecs.hibernateproject.operations;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionException;

import org.hibernate.query.Query;

import com.atmecs.hibernateproject.entity.Employee;
import com.atmecs.hibernateproject.util.HibernateUtil;

import javassist.bytecode.Descriptor.Iterator;

public class ReadAllData {
	public void readAll() {
		Session session = HibernateUtil.currentSession();

		try {
			session.beginTransaction();
			Query query = session.createQuery("From Employee");
			List list = query.list();
			System.out.println("All Data:" + list.size());
			Iterator itr = (Iterator) list.iterator();
			while (itr.hasNext()) {
				Object obj = (Object) itr.next();
				Employee employee = (Employee) obj;
				System.out.println("Id is:" + employee.getId());
				System.out.println("First Name : " + employee.getFirstname());
				System.out.println("Last Name : " + employee.getLastname());
				System.out.println("Email : " + employee.getEmail());
				System.out.println("Record Displayed successfully");
			}
			session.getTransaction().commit();
		} catch (SessionException e) {
			System.out.println(e);
		} finally {
			HibernateUtil.closeSession();
		}
	}
}
