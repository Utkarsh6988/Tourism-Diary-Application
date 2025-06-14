import java.util.*;

interface Phone {
	default void makeCall(String number) {
		System.out.println("Calling:"+ number);
	}
	void recieveCall();
}

interface Camera {
	default void takePhoto() {
		System.out.println("Taking a photo");
	}
	void recordVedio();
}

class SmartDevice implements Phone, Camera{
	private String owner;
	
	public SmartDevice(String owner) {
		this.owner=owner;
	}
	
	@Override
	public void recieveCall() {
		System.out.println(owner+"'s phone is ringing");
	}
	
	@Override
	public void recordVedio() {
		System.out.println(owner+"is recording vedio");
	}
	
	public  void vedioCall(String number) {
		makeCall(number);
		recordVedio();
	}
}

public class MultipleInheritanceDemo {
   public static void main(String args[]) {
	   Scanner sc = new Scanner(System.in);
	   System.out.print("Enter device owner's name");
	   String owner = sc.nextLine();
	   
	   SmartDevice  myDevice = new SmartDevice(owner);
	   
	   while(true) {
		   System.out.println("\n1. Make Call");	  
		   System.out.println("2. Recieve Call");
		   System.out.println("3. Take Photo");
		   System.out.println("4. Record Vedio");
		   System.out.println("5. Vedio Call");
		   System.out.println("6. Exit");
		   System.out.print("Choose an option: ");
		   
		   int choice = sc.nextInt();
		   sc.nextLine();
		   
		   switch(choice) {
		   case 1: 
			   System.out.print("Enter no. to make Call");
			   String number = sc.nextLine();
			   myDevice.makeCall(number);
			   break;
		   case 2:
			   myDevice.recieveCall();
			   break;
		   case 3:
			   myDevice.takePhoto();
			   break;
		   case 4:
			   myDevice.recordVedio();
			   break;
		   case 5:
			   System.out.println("Enter a number fo a vedio call:");
			   String vedioNumber = sc.nextLine();
		       myDevice.vedioCall(vedioNumber);
		       break;
		   case 6:
			   System.out.println("Goodbye");
			   sc.close();
			   return;
		   default:
			   System.out.println("Invalid Choice !");
			   
	   }
	   }
   }
}
