package com.utkarsh.HibernateDemo.HibernateDemo;
import java.beans.Expression;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.hibernateclass.entities.Employee;
import com.example.hibernateclass.utils.HibernateUtils;
//
//public class Services {
//   SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
//   
//   //save data 
//   public void saveData(Employee emp) {
//	   try(Session session = sessionFactory.openSession()) {
//		
//		   Transaction transaction = session.beginTransaction();
//		   session.persist(emp);
//		   transaction.commit();
//		   
////		   emp=session.get(Employee.class, 2);
////		   session.remove(emp);
////		   transaction.commit();
//		   
//	} 
//   }
//   
//   public Employee updateData(int id) {
//	   try(Session session = sessionFactory.openSession()){
//		   Employee oldEmployee = session.get(Employee.class, id);
//		   oldEmployee.setName(oldEmployee.getName());
//		   session.merge(oldEmployee);
//		   return oldEmployee;
//	   } catch (Exception e) {
//		// TODO: handle exception
//		   return null;
//	}
//   }
//}


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;





public class Services {

	SessionFactory sessionFactory=HibernateUtils.getSessionFactory();
	
	// saving data 
	public void saveData(Employee emp) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.persist(emp); 
            tx.commit();       
        } catch (Exception e) {
            if (tx != null) tx.rollback(); 
            e.printStackTrace();           
        }
       
    }
	// geting emp by id
	public Employee getEmployeeById(int id) {
	    Employee emp = null;
	    try (Session session = sessionFactory.openSession()) {
	        emp = session.get(Employee.class, id); // Fetch employee by primary key
	        if (emp != null) {
	            System.out.println("Employee Found: " + emp.getName());
	        } else {
	            System.out.println("No Employee found with ID: " + id);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return emp;
	}// Del emp by id
	public void deleteEmp(int id) {
	    Employee emp = null;
	    Transaction tx = null;
	    try (Session session = sessionFactory.openSession()) {
	    	
	        emp = session.get(Employee.class, id); // Fetch employee by primary key
	        if (emp != null) {
	        	tx = session.beginTransaction();
	            session.remove(emp);
	            tx.commit();
	            System.out.println("Employee deletted : " + id);
	        } else {
	            System.out.println("No Employee found with ID: " + id);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	// 🔄 NEW: mergeEmployee method using a detached object
    public void mergeEmployee(Employee detachedEmp) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();

            // merge() returns a managed instance with updated values
            Employee managedEmp = (Employee) session.merge(detachedEmp);
            tx.commit();
            System.out.println("Employee merged successfully.");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
  public Employee updateData(int id) {
	   try(Session session = sessionFactory.openSession()){
		   Employee oldEmployee = session.get(Employee.class, id);
		   oldEmployee.setName(oldEmployee.getName());
		   session.merge(oldEmployee);
		   return oldEmployee;
	   } catch (Exception e) {
		// TODO: handle exception
		   return null;
	}
}
		
	}