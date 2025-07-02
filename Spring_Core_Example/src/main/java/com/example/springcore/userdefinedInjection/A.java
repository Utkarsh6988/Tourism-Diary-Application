package com.example.springcore.userdefinedInjection;

public class A {
	
	private int id;
	private B objB;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public B getObjB() {
		return objB;
	}
	public void setObjB(B objB) {
		this.objB = objB;
	}
	public A() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "A [id=" + id + ", objB=" + objB + "]";
	}

	

}
