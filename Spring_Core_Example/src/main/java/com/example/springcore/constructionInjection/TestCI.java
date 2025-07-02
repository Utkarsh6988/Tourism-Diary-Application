package com.example.springcore.constructionInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCI {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/example/springcore/constructionInjection/config.xml");

		ConstructionInjectionDemo con = (ConstructionInjectionDemo) context.getBean("ci");
		System.out.println(con);
	}
}
