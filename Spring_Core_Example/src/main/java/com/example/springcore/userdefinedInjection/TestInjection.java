package com.example.springcore.userdefinedInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestInjection {

	public static void main(String[] args) {
		
		
		ApplicationContext context= new  ClassPathXmlApplicationContext("com/example/springcore/userdefinedInjection/config.xml");
		A a = (A) context.getBean("refA");

		System.out.println(a);
	}

}
