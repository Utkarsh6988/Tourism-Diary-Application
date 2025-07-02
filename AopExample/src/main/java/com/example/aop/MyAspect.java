package com.example.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


@Aspect
public class MyAspect {
   
	@Before("execution(* com.example.aop.services.PaymentServiceImpl.makePayment(..))")
	public void Before() {
		System.out.println("Payment Service initiated");
	}
	
	@After("execution(* com.example.aop.services.PaymentServiceImpl.makePayment(..))")
	public void after() {
		System.out.println("Payment service completed");
	}
}

