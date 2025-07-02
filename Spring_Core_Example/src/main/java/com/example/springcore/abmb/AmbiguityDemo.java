package com.example.springcore.abmb;

public class AmbiguityDemo {

	private int a;
	private int b;

	public AmbiguityDemo(int a, int b) {
		super();
		this.a = a;
		this.b = b;
		System.out.println("Calling int int");
	}

	public AmbiguityDemo(double a, double b) {
		super();
		this.a = (int) a;
		this.b = (int) b;
		System.out.println("Calling double double");
	}

	public AmbiguityDemo(String a, String b) {
		super();
		this.a = Integer.parseInt(a);
		this.b = Integer.parseInt(b);

		System.out.println("Calling String String");
	}

	public void show() {
		System.out.println("Value of a: " + this.a + "\nValue of b: " + this.b);
	}

	
	//According to this it will by default give String output , If we remove string constructor , then it will use constructor according to order of precedence(means jo constructor upar hain), or you need to specify type in config.xml file 
}
