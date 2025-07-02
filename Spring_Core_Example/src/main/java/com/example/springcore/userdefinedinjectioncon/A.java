package com.example.springcore.userdefinedinjectioncon;

public class A {
	private int x;
	
	private B objB;

	public A(int x, B objB) {
		super();
		this.x = x;
		this.objB = objB;
	}

	@Override
	public String toString() {
		return "A [x=" + x + ", objB=" + objB + "]";
	}

	
	
}
