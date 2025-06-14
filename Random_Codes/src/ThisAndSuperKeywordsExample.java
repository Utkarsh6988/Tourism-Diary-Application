class Employee{
	String name;
	int salary;
	
	Employee(String name, int salary){
		this.name=name;
		this.salary=salary;
	}
	
	void display() {
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
	void display() {
		System.out.print("Name:"+ name +" "+ "salary:"+salary+" " +"Department:"+department);
	}
}

public class ThisAndSuperKeywordsExample {
	public static void main(String[]args) {
   Manager mgr = new Manager("Utkarsh Arora", 100000, "IT");
   mgr.display();
	}
}
