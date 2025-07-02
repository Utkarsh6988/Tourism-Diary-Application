package com.example.springcore.userdefinedinjectioncon;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCI {

	public static void main(String[] args) {
		
		ApplicationContext context= new ClassPathXmlApplicationContext("com/example/springcore/userdefinedinjectioncon/config.xml");
		A a= (A) context.getBean("refA");
		System.out.println(a);

	}

}
