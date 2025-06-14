class Employee{
	String name;
	int salary;
	
	Employee(String name, int salary){
		this.name=name;
		this.salary=salary;
	}
	
	void calculateSalary() {
		System.out.print("Name:"+ name + "salary:"+salary );
	}
}

class Manager extends Employee{
	String department;
	
	Manager(String name, int salary, String department){
		super(name,salary);
		this.department = department;
	}
	
	@Override
	void calculateSalary() {
		System.out.print("Name:"+ name +" "+ "salary:"+salary+" " +"Department:"+department);
	}
}

class Developer extends Employee{
	String department;
	
	Developer(String name, int salary, String department){
		super(name,salary);
		this.department = department;
	}
	
	@Override
	void calculateSalary() {
		System.out.print("Name:"+ name +" "+ "salary:"+salary+" " +"Department:"+department);
	}
}

public class EmployeeCode {
	public static void main(String[]args) {
   Manager mgr = new Manager("Utkarsh Arora", 100000, "HR");
   mgr.calculateSalary();
   
   System.out.println();
   Developer dr = new Developer("Raunak Arora", 1200000, "IT");
   dr.calculateSalary();
	}
}
