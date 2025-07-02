package com.example.springcore.constructionInjection;

public class ConstructionInjectionDemo {
    
	
	private int id;
	private String name;
	private int age;
	
	public ConstructionInjectionDemo(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "ConstructionInjectionDemo [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
}
