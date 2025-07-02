package com.springcore.example.Spring_Core_Example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
       ApplicationContext context= new ClassPathXmlApplicationContext("config.xml"); //Sub class of ApplicationContext
       
      Student student = (Student) context.getBean("student1");
       
       
       System.out.println(student);
       
    }
}
