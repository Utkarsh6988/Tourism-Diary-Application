package com.example.Employee;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;



public class Employee {

	private int id;
	private List<String> phonenos;
	private Set<String> addresses;
	private Map<String, String> increments;
	private Properties property;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<String> getPhonenos() {
		return phonenos;
	}
	public void setPhonenos(List<String> phonenos) {
		this.phonenos = phonenos;
	}
	public Set<String> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<String> addresses) {
		this.addresses = addresses;
	}
	
	public Map<String, String> getIncrements() {
		return increments;
	}
	public void setIncrements(Map<String, String> increments) {
		this.increments = increments;
	}
	



	public Properties getProperty() {
		return property;
	}
	public void setProperty(Properties property) {
		this.property = property;
	}

	public Employee(int id, List<String> phonenos, Set<String> addresses, Map<String, String> increments,
			Properties property) {
		super();
		this.id = id;
		this.phonenos = phonenos;
		this.addresses = addresses;
		this.increments = increments;
		this.property = property;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", phonenos=" + phonenos + ", addresses=" + addresses + ", increments="
				+ increments + ", property=" + property + "]";
	}


	

	
	
}
