import java.io.*;

class BankDetails implements Serializable {

	int Bank_ID;
	String Bank_Name;
	String bank_Address;
	int totalEmployee;

	public BankDetails(int bank_ID, String bank_Name, String bank_Address, int totalEmployee) {
//		super();
		Bank_ID = bank_ID;
		Bank_Name = bank_Name;
		this.bank_Address = bank_Address;
		this.totalEmployee = totalEmployee;
	}

}

public class Bank {
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		// Object Serialization
		BankDetails ob = new BankDetails(10, "HDFC", "Charbagh,Lucknow", 50);
		FileOutputStream fos = new FileOutputStream("D:\\bank.txt", true);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(ob);
		oos.close();
		fos.close();

		// Object De-serialization
		BankDetails ob1;
		FileInputStream fis = new FileInputStream("D:\\bank.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		ob1 = (BankDetails) ois.readObject();
		System.out.println("Bank_ID" + " " + "Bank_Name" + " " + "Bank_Address" + " " + "Total Employee");
		System.out.println();
		System.out.println(ob1.Bank_ID + "\t" + ob1.Bank_Name + "\t" + ob1.bank_Address + "\t" + ob1.totalEmployee);
	}
}
