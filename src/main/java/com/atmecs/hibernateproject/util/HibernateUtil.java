package com.atmecs.hibernateproject.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.atmecs.hibernateproject.entity.Employee;


public class HibernateUtil {
//	private static final Session session;
//    
//    static{
//        try{
//        	Configuration configuration=new Configuration();
//        	SessionFactory sessionFactory = configuration.configure().addAnnotatedClass(Employee.class).buildSessionFactory();
//        //	 session=sessionFactory.openSession();
//        	 session=sessionFactory.getCurrentSession();
// 
//        }catch (Throwable e) {
//            System.err.println("Session Factory could not be created." + e);
//            throw new ExceptionInInitializerError(e);
//        }   
//    }
//     
//    public static Session getSession() {
//        return session;
//    }
	
	 public static final SessionFactory sessionFactory;

	  static {
	    try {
	      Configuration config = new Configuration().addAnnotatedClass(Employee.class).configure();
	      sessionFactory = config.buildSessionFactory();
	    } catch (Throwable e) {
	      System.err.println("Initial SessionFactory creation failed." + e);
	      throw new ExceptionInInitializerError(e);
	    }
	  }

	  public static final ThreadLocal session = new ThreadLocal();

	  public static Session currentSession() throws HibernateException {
	    Session s = (Session) session.get();
	    // Open a new Session, if this thread has none yet
	    if (s == null) {
	      s = sessionFactory.openSession();
	      // Store it in the ThreadLocal variable
	      session.set(s);
	    }
	    return s;
	  }

	  public static void closeSession() throws HibernateException {
	    Session s = (Session) session.get();
	    if (s != null)
	      s.close();
	    session.set(null);
	  }

}
