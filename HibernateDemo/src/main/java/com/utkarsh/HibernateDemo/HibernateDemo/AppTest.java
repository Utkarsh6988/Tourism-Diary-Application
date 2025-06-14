package com.utkarsh.HibernateDemo.HibernateDemo;

import com.example.hibernateclass.entities.Employee;

public class AppTest {
   
	Services services = new Services();
	
	public void testEmpLoan() {
		Employee emp= services.getEmployeeById(1);
		System.out.println(emp.getLoans().size());
//		System.out.println(emp.getLoans().getFirst());
		
	}
}
