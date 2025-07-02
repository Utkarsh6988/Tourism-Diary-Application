package com.springcoreExample.lifecycle;

public class Lifecycle {
    private String name;

	public String getName() {
		System.out.println("Getting Name:");
		return name;
	}

	public void setName(String name) {
		System.out.println("Setting name");
		this.name = name;
	}

	public Lifecycle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void start() {
		System.out.println("Inside Init Method");
	}
	public void end() {
		System.out.println("Inside destroy method");
	}

	@Override
	public String toString() {
		return "Lifecycle [name=" + name + "]";
	}
	
	
    
    
}
