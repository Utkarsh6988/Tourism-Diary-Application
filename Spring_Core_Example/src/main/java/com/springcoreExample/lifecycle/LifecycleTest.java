package com.springcoreExample.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifecycleTest {
   public static void main(String[] args) {
	
//	   ApplicationContext context = new ClassPathXmlApplicationContext("com/springcoreExample/lifecycle/config.xml");
	  AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/springcoreExample/lifecycle/config.xml");  // After this line and its below line , then only you will see end method  
	  context.registerShutdownHook();
	  Lifecycle l= (Lifecycle) context.getBean("lc");
	  System.out.println(l);
	  
	  System.out.println("+++++++++++++++++++++++++++++++++++");
}
}

