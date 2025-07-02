package com.example.aop.services;

public class paymentServiceImpl implements PaymentServices {
 
	@Override
	public void makePayment(int amount) {
		// TODO Auto-generated method stub
		System.out.println("Amount Debited ");
		System.out.println("Amount Credited ");
	}
}
