package com.utkarsh.app.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component               //By this annotation spring gets to know that , spring only need to manage , create and update the object
public class Alien {
	
	@Value("25")
	private int age;
	
	
	private Computer comp;
	
	
	
	
	public int getAge() {
		return age;
	}




	public void setAge(int age) {
		this.age = age;
	}




	public Computer getComp() {
		return comp;
	}

	
	@Autowired           //Now its spring responsibility to search the laptop object in a container. 
	@Qualifier("laptop")
	public void setComp(Computer comp) {
		this.comp = comp;
	}
	
	public void code() {
//		laptop.compile();
		comp.compile();
//		System.out.println("Coding");
	}

}
