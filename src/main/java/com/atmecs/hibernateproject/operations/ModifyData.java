package com.atmecs.hibernateproject.operations;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.atmecs.hibernateproject.entity.Employee;
import com.atmecs.hibernateproject.util.HibernateUtil;

public class ModifyData {
	public void updateData() {
		Session session = HibernateUtil.currentSession();
		Scanner sc = new Scanner(System.in);
		try {
			session.beginTransaction();
			System.out.println("Enter id to modify record:");
			Employee employee = (Employee) session.get(Employee.class, sc.nextInt());

			if (employee != null) {
				System.out.println("Enter the new email to update");
				employee.setEmail(sc.next());
				session.saveOrUpdate(employee);

				session.getTransaction().commit();
				System.out.println("Record updated successfully..!!");
			} else {
				System.out.println("Record not found for given id, please enter a correct id");
			}
		} catch (SessionException e) {
			System.out.println(e);
		} finally {
			HibernateUtil.closeSession();
		}

	}
}
