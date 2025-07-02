package com.example.restexample.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.restexample.empservices.EmployeeServices;
import com.example.restexample.entities.Employees;

@RestController
public class EmployeeController {

	
//	@RequestMapping(value="/employees", method=RequestMethod.GET)
//	@ResponseBody
	
	@Autowired
	private EmployeeServices empservice;
	
//	@GetMapping("/employees")
//	public String getEmployee() {
//		
//		Employees employees = new Employees();
//		employees.setId(1);
//		employees.setName("Nirankar");
//		employees.setDepartmant("CSE");
//		
//		return employees;
		
	@GetMapping("/employees")
	public List<Employees> getEmployees(){
		
		List<Employees> allEmployees = empservice.getAllEmployees();
		return allEmployees;
		
	}
	
	@GetMapping("/employees/{id}")
	public Employees getEmployeeById(@PathVariable("id") int id) {
		
		Employees empById = empservice.getEmpById(id);
		return empById;
	}
	
	@PostMapping("/employees")
	public Employees addEmployee(@RequestBody Employees emp) {
		Employees employee=empservice.addEmployee(emp);
				return employee;
	}
	
	@PutMapping("/employees/{id}")
	public void updateEmp(@RequestBody Employees emp, @PathVariable("id") int id) {
		empservice.updateEmployee(emp, id);
	}
	
}


