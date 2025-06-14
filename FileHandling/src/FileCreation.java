import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
//import java.io.FileReader;
//import java.util.*;

public class FileCreation {
	public static void main(String args[]) {
             
		try {
		 File obj = new File("D:\\Data.txt");
		 if(obj.createNewFile())
		 {
			 System.out.println("File is created");
			 System.out.println("The name of the file is ="+obj.getName());
		 }
		 else {
			 System.out.println("File already exists");
		 }
		 
		  FileWriter f = new FileWriter("D:\\Data.txt");  // By default it is in truncate mode (false mode) , to write again make it append mode by adding true ileWriter f = new FileWriter("D:\\Data.txt", true);  
		  f.write("Welcome to AI");
		  f.close();
	    }
		catch(IOException e)
		{
			System.out.println("File Creation Error");
			e.printStackTrace();
		}
	}
              
}


//Read the content line by line we use hasNextLine()
//to delete use delete() function 
