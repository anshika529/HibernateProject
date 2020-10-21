package com.atmecs.hibernateproject.operations;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.atmecs.hibernateproject.entity.Employee;
import com.atmecs.hibernateproject.util.HibernateUtil;

public class ReadData {
	public void readData() {
		Session session = HibernateUtil.currentSession();
		Scanner sc = new Scanner(System.in);
		try {
			session.beginTransaction();
			System.out.println("Enter id to read the data:");
			Employee employee = (Employee) session.get(Employee.class, sc.nextInt());
			System.out.println("Id is:" + employee.getId());
			System.out.println("First Name : " + employee.getFirstname());
			System.out.println("Last Name : " + employee.getLastname());
			System.out.println("Email : " + employee.getEmail());
			System.out.println("Record Displayed successfully");
		} catch (SessionException e) {
			System.out.println(e);
		} finally {
			HibernateUtil.closeSession();
		}
	}
}
