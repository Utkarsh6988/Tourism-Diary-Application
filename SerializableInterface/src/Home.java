import java.io.*;

//@SuppressWarnings("serial")
class HomeDetails implements Serializable {
	int h_no;
	String address;
	String owner;

	public HomeDetails(int h_no, String address, String owner) {
		super();
		this.h_no = h_no;
		this.address = address;
		this.owner = owner;
	}

}

public class Home {
	public static void main(String[] args) throws Exception {

		HomeDetails hDetails = new HomeDetails(5, "Charbagh", "Utkarsh Arora");

		String str = "Welcome to AI    ";
		FileWriter fWriter = new FileWriter("D:\\home.txt");
		fWriter.write(str);
		System.out.println();
		FileOutputStream fos = new FileOutputStream("D:\\home.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(hDetails);
		fWriter.close();
		oos.close();
		fos.close();
	}
}
