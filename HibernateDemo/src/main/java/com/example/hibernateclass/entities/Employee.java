package com.example.hibernateclass.entities;

import java.util.ArrayList;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "emp_info")
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  // Removed 'static'

    @Column(name = "emp_name", length = 200)
    private String name;  // Removed 'static'
    
    @Column(name = "emp_age")
    private int age;  // Removed 'static'
    
    @Lob
    private String about;  // Removed 'static'
    
    private boolean active = false;  // This is correct (non-static)
    
    @OneToMany(mappedBy = "employee", fetch=FetchType.EAGER, cascade = CascadeType.ALL) // after this only two tables will be created not three
//    @OneToMany(mappedBy = "employee", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Loan> loans = new ArrayList<>();
    
    
    public List<Loan> getLoans() {
		return loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}

	// Add constructors, getters, and setters
    public Employee() {
        // Default constructor required by Hibernate
    }

    // Getters and setters for all fields
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}