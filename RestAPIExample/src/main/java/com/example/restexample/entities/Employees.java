package com.example.restexample.entities;

public class Employees {
   
	private int id;
	private String name;
	private String departmant;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartmant() {
		return departmant;
	}
	public void setDepartmant(String departmant) {
		this.departmant = departmant;
	}
	public Employees(int id, String name, String departmant) {
		super();
		this.id = id;
		this.name = name;
		this.departmant = departmant;
	}
	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
