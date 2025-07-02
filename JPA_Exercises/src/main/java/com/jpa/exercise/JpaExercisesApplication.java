package com.jpa.exercise;

import java.lang.invoke.CallSite;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.exercise.dao.EmployeeRepository;
import com.jpa.exercise.entities.Employee;

@SpringBootApplication
public class JpaExercisesApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(JpaExercisesApplication.class, args);
		EmployeeRepository repo= context.getBean(EmployeeRepository.class);
		
//		Employee e1 = new Employee();
//		e1.setName("Utkarsh Arora");
//		e1.setCity("Lucknow");
//		e1.setCountry("India");
//		Employee e2 = new Employee();
//		e2.setName("Sarthak Arora");
//		e2.setCity("Lucknow");
//		e2.setCountry("India");
//		Employee e3 = new Employee();
//		e3.setName("Mahima ");
//		e3.setCity("Karnal");
//		e3.setCountry("India");
//		Employee e4 = new Employee();
//		e4.setName("Suraj");
//		e4.setCity("Gujrat");
//		e4.setCountry("India");
//		
////		Employee save = repo.save(e1);
//		
//	    List<Employee> listOEmployees = List.of(e1, e2,e3,e4);
//	    Iterable<Employee> saveAll= repo.saveAll(listOEmployees);
//	    System.out.println(saveAll);
	    
	    Optional<Employee> foundRecordByIdOptional = repo.findById(1);
	    System.out.println(foundRecordByIdOptional);
		
	}

}
