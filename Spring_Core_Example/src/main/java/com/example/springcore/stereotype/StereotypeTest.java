package com.example.springcore.stereotype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StereotypeTest {
    public static void main(String[] args) {
		
    	ApplicationContext context = new ClassPathXmlApplicationContext("com/example/springcore/stereotype/config.xml");
    	
    	Person person = context.getBean("obj", Person.class);
    	
    	System.out.println("person hashcode: "+person.hashCode());
    	Person person1 = (Person) context.getBean("obj");  // Both ways are correct
    	
    	System.out.println("person1 hashcode: "+person1.hashCode());
    	
    	System.out.println(person);
	}
}
