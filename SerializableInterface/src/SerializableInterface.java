// Make an object Serializable when u want to save the entire object in a file
// This will happen if you convert the object into byte stream

import java.io.*;

class Employee implements Serializable // Serializable is a marker interface, an interface which has no member inside it
										 
{

	int id;
	String name;

	Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}
}

public class SerializableInterface {
	public static void main(String args[]) throws Exception {
		// Object Serialization
		Employee emp = new Employee(12, "Rahul");
		FileOutputStream fos = new FileOutputStream("D:\\fos.txt", true); // Open file in append mode, once it is
																			// created
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(emp); // its a function of ObjectOutputStream which converts the object in binary form
		oos.close();
		fos.close();

		// Object De-Serialization
		Employee emp1;
		FileInputStream fis = new FileInputStream("D:\\fos.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		emp1 = (Employee) ois.readObject(); // typecasting is required because readObject() returns an object
		System.out.println(emp1.id + "\t" + emp1.name);

		// Note that you can not read the .txt file
	}

}