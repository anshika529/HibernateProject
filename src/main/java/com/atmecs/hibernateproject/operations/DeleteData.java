package com.atmecs.hibernateproject.operations;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.Transaction;

import com.atmecs.hibernateproject.entity.Employee;
import com.atmecs.hibernateproject.util.HibernateUtil;

public class DeleteData {
	public void deleteData() {
		Session session = HibernateUtil.currentSession();
		Scanner sc = new Scanner(System.in);
		try {
			session.beginTransaction();
			System.out.println("Enter id to delete record:");
			Employee employee = (Employee) session.get(Employee.class, sc.nextInt());

			if (employee != null) {
				session.delete(employee);
				session.getTransaction().commit();
				System.out.println("Record deleted successfully..!!");
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
