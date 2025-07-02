package com.example.restexample.empservices;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.restexample.entities.Employees;

@Component
public class EmployeeServices {
	
	private static List<Employees> emplist = new ArrayList<>();
			static {
		emplist.add(new Employees(1,"Shiv", "CSE"));
		emplist.add(new Employees(2,"Krishna", "Management"));
		emplist.add(new Employees(3,"Bhola", "CS"));
		emplist.add(new Employees(4,"Makhanchor", "Accounts"));
		
	}
			
    public List<Employees> getAllEmployees(){
    	
    	return emplist;
    }

    public Employees getEmpById(int id) {
    	
    	Employees employees= emplist.stream().filter(e->e.getId() == id).findFirst().get();
    	return employees;
    }
    public Employees addEmployee(Employees newEmp) {
    	emplist.add(newEmp);
    	return newEmp;
    }
    
    public void updateEmployee(Employees emp,int id) {
    emplist= emplist.stream().map(e->{
    		if(e.getId()==id) {
    			e.setId(emp.getId());
    			e.setName(emp.getName());
    			e.setDepartmant(emp.getDepartmant());
    		}
    		return e;
    	}).collect(Collectors.toList());
    }
}
