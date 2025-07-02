package com.example.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.aop.services.PaymentServices;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/example/aop/config.xml");
        PaymentServices ps = context.getBean("paymentservice",PaymentServices.class);
        ps.makePayment(1000);
    }
}
