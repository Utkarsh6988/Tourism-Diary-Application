package com.example.hibernateclass.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Loan {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //If you remove cascade=CascadeType.ALL, operations like persist(), merge(), or remove() on the parent entity will not automatically propagate to the child entities.
	private int loan_id;
	private double loanamount;
	
	@ManyToOne
//	@JoinColumn(name = "emp_id")
	private Employee employee;

	public int getLoan_id() {
		return loan_id;
	}

	public void setLoan_id(int loan_id) {
		this.loan_id = loan_id;
	}

	public double getLoanamount() {
		return loanamount;
	}

	public void setLoanamount(double loanamount) {
		this.loanamount = loanamount;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
