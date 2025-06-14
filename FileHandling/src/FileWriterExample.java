import java.io.*;


public class FileWriterExample {
       public static void main(String[]args) {
    	        
    	   
	             String Text="Hello! Utkarsh";
	             try(FileWriter fw = new FileWriter("output.txt")){
	            	 fw.write(Text);
	            	 System.out.println("Text written successfully");
	             }
	             catch(IOException e) {
	            	 e.printStackTrace();
	             }
        }
}

//The FileWriter class will automatically:
//
//Create the file if it does not exist.
//
//Overwrite the file if it does exist (unless you use an append flag, explained below).