package com.utkarsh.HibernateDemo.HibernateDemo;

import com.example.hibernateclass.entities.Employee;
import com.example.hibernateclass.entities.Loan;
import com.example.hibernateclass.utils.HibernateUtils;

import java.beans.beancontext.BeanContextServices;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
        
//        Employee emp = new Employee();
        
//        emp.setName("Utkarsh");
//        emp.setAge(25);
//        emp.setActive(true);
//        emp.setAbout("He is an excellent student");
        
//        emp.setName("Sarthak");
//        emp.setAge(22);
//        emp.setActive(true);
//        emp.setAbout("Employee 4");
//        
//        Loan loan = new Loan();
//        loan.setLoanamount(10000);
//        loan.setEmployee(emp);
//        
//        
//        Loan loan1 = new Loan();
//        loan1.setLoanamount(20000);
//        loan1.setEmployee(emp);
//        
//        emp.getLoans().add(loan);
//        emp.getLoans().add(loan1);
//        
//        
//        
////    	SessionFactory sessionFactory = new HibernateUtils().getSessionFactory();
//    	Services s = new Services();
//    	s.saveData(emp);
//    	
//        
//    	Session session = sessionFactory.openSession();
//    	Transaction transaction=null;
//    	
//    	try {
//			transaction= session.beginTransaction();
//			session.persist(emp);
//			transaction.commit();
//			System.out.println("Data Saved Successfully");
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			if(transaction!=null) {
//				transaction.rollback();
//			}
//			else {
//				e.printStackTrace();
//			}
//		} finally {
//			session.close();
//		}
//    	
//        //        System.out.println(sessionFactory);
    	
    	
    	Services services = new Services();
    	Employee emp= services.getEmployeeById(1);
    	System.out.println(emp.getName());
    	System.out.println(emp.getLoans());
       }
}

