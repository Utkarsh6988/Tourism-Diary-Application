package com.example.springcore.abmb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAmb {
   public static void main(String[] args) {
	
	   ApplicationContext context= new ClassPathXmlApplicationContext("com/example/springcore/abmb/config.xml");
	   AmbiguityDemo a = (AmbiguityDemo) context.getBean("amb"); 
	   a.show();
}
}
