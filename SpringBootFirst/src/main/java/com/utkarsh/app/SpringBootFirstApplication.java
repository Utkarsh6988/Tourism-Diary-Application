package com.utkarsh.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.utkarsh.app.model.Alien;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootFirstApplication {

	public static void main(String[] args) {
		
		
		//ApplicationContext (Spring IoC container).
		//SpringBootFirstApplication.class.This is the main application class (annotated with @SpringBootApplication).
		ApplicationContext context = SpringApplication.run(SpringBootFirstApplication.class, args);
		
//		SpringApplication.run(SpringBootFirstApplication.class, args);
//		System.out.println("Hello World!!");
		
//		Alien ob= new Alien();
		
		//Now making object through spring as I mentioned component on Alien class
		Alien ob= context.getBean(Alien.class);
		System.out.println(ob.getAge());
		ob.code();
		
//		Laptop lap = context.getBean(Laptop.class);
//		lap.compile();
		
		
	}

}


//SpringApplication.run()
//This method bootstraps (starts) the Spring Boot application.
//
//It performs several key tasks:
//
//Creates an ApplicationContext (Spring IoC container).
//
//Starts the embedded web server (Tomcat, Jetty, or Netty) if it's a web app.
//
//Auto-configures Spring and third-party libraries.
//
//Scans for Spring components (@Component, @Service, @Controller, etc.).
//
//Runs CommandLineRunner or ApplicationRunner beans (if any).