//Used to read binary data, e.g., images or raw files.


import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamExample {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("input.bin")) {
            int data;
            while ((data = fis.read()) != -1) {
                System.out.print((char) data); // Print byte as char
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
