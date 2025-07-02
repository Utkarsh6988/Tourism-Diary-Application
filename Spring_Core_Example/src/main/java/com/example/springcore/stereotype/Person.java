package com.example.springcore.stereotype;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("obj")
@Scope("prototype")
public class Person {
   
//	@Value("10") //Field Injection
	private int id;
	
    private String name;
    
//    @Value("#{phone}")  //Field Injection 
    private List<String> phonenos;

	public int getId() {
		return id;
	}

//	@Value("101") //Setter Injection
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getPhonenos() {
		return phonenos;
	}

	public void setPhonenos(List<String> phonenos) {
		this.phonenos = phonenos;
	}

	public Person(@Value("102") int id, @Value("Utkarsh")String name, @Value("#{phone}")List<String> phonenos) {
		super();
		this.id = id;
		this.name = name;
		this.phonenos = phonenos;
	}



	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", phonenos=" + phonenos + "]";
	}
    
	
    
}
