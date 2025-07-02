package com.example.Employee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpTest {

	public static void main(String[] args) {
         
		ApplicationContext context=new ClassPathXmlApplicationContext("com/example/Employee/configemp.xml");
		
		Employee emp=(Employee) context.getBean("employee1");
		
		System.out.println(emp);
	}
}
