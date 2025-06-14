import java.io.*;


public class BufferedOutputStreamExample {
    public static void main(String[]args) {
    	String data="Chak Dhoom Dhoom !! Chak Dhoom Dhoom!!";
    	
    	try(
    			FileOutputStream fos = new FileOutputStream("buffered_output.bin");
    			BufferedOutputStream bos = new BufferedOutputStream(fos)
    			) {
    		        bos.write(data.getBytes());
    		        bos.flush();
    		        System.out.println("Data written to buffered_output.bin successfully");
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    	
    }
}
