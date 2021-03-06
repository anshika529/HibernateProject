package com.atmecs.hibernateproject.operations;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.atmecs.hibernateproject.entity.Employee;
import com.atmecs.hibernateproject.util.HibernateUtil;

public class AddData {
	public void adddata() {
		Session session = HibernateUtil.currentSession();
		Scanner sc = new Scanner(System.in);

		try {
			session.beginTransaction();
			System.out.println("Enter the number of records you want to add");
			int number = sc.nextInt();
			for (int i = 1; i <= number; i++) {
				Employee employee = new Employee();
				System.out.println("Enter Employee Details");
				System.out.println("Enter id:");
				employee.setId(sc.nextInt());
				System.out.println("Enter First Name:");
				employee.setFirstname(sc.next());
				System.out.println("Enter Last Name:");
				employee.setLastname(sc.next());
				System.out.println("Enter Email:");
				employee.setEmail(sc.next());
				session.save(employee);
				session.getTransaction().commit();
				System.out.println("Record successfully added to the table");
			}
		} catch (SessionException e) {
			System.out.println(e);
		} finally {
			HibernateUtil.closeSession();
		}

	}
}
