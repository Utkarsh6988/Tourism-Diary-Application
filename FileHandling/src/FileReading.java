import java.io.File;
import java.io.IOException;
import java.util.*;


public class FileReading {
	public static void main(String args[]) {
        
		try {
		 File obj = new File("D:\\Data.txt"); 
          Scanner read = new Scanner(obj);
          while(read.hasNextLine()) {
        	  String str = read.nextLine();
        	  System.out.println(str);
          }
          read.close();
          System.out.println("The Absolute path is = "+obj.getAbsolutePath());
          System.out.println("The length of the file is ="+obj.length());
		  
	    }
		catch(IOException e)
		{
			System.out.println("File Creation Error");
			e.printStackTrace();
		}
	}
              
}

//Vertical Space /n has two counts 
//Horizontal Space has one count 