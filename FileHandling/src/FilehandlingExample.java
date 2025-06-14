import java.io.*;



public class FilehandlingExample {
     public static void main(String[]args) {
    	 
    	   File parentFolder = new File("D:\\Parent Folder");
    	   if(!parentFolder.exists()) {
    		   parentFolder.mkdir();
    		   System.out.println("Parent Folder created successfully");
    	   }
    		   
    	 
           String text = "Data is different than information";
           String text1= "Deep Learning is subset of Machine Learning";
           
           String file1Path = "D:\\Parent Folder\\file1.txt";
           String file2Path = "D:\\Parent Folder\\file2.txt";

           
           try(FileWriter fw = new FileWriter(file1Path)){
        	   fw.write(text);
        	   System.out.println("Text written successfully in file 1");
        	   fw.close();	
           }
           catch(IOException e) {
        	   e.printStackTrace();
           }
           
           try(FileWriter fw1 = new FileWriter(file2Path)){
        	   fw1.write(text1);
        	   System.out.println("Text written successfully in file 2");
        	   fw1.close();	
           }
           catch(IOException e) {
        	   e.printStackTrace();
           }
           
           //Read and Display content of both files
           System.out.println("\nReading Both files");
           readAndDisplayFile(file1Path);
           readAndDisplayFile(file2Path);
           
           String additionalText = "Gradel is more Complex than Maven";
           try(FileWriter fw2 = new FileWriter(file2Path, true)){
        	   fw2.write(additionalText);
        	   fw2.close();
           }
           catch(IOException e) {
        	   e.printStackTrace();
           }
           
          // Display file2.txt length
           File file2 = new File(file2Path);
           System.out.println("Length of file2.txt: " + file2.length() + " bytes");

           // Display updated contents of file2.txt
           System.out.println("\nUpdated content of file2.txt:");
           readAndDisplayFile(file2Path);
           
           
//            Delete Parent Folder and its contents
//           boolean isDeleted = deleteDirectory(parentFolder);
//           if (isDeleted) {
//               System.out.println("\nParent Folder and all files deleted successfully!");
//           } else {
//               System.out.println("\nFailed to delete Parent Folder.");
//           }
     }
     private static void readAndDisplayFile(String filePath) {
    	 try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
    		 System.out.println("\nContents of:" + filePath + ":");
    		 String line;
    		 
    		 while((line = br.readLine()) != null) {   //Read until the end of the line 
    			 System.out.println(line);             //Print each line 
    		 }
    	 }
    	 catch(IOException e) {
    		 e.printStackTrace();
    	 }
     }
     
  // Helper method to recursively delete a directory and its contents
     private static boolean deleteDirectory(File directory) {
         if (directory.isDirectory()) {
             File[] files = directory.listFiles();
             if (files != null) {
                 for (File file : files) {
                     deleteDirectory(file); // Recursively delete files/subdirectories
                 }
             }
         }
         return directory.delete(); // Delete the directory itself
     }

}
