import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterExample {
    public static void main(String[] args) {
        String filePath = "output.txt";
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Writing data
            writer.write("Hello, World!");  // Writes a string
            writer.newLine();               // Adds a newline (platform-independent)
            writer.write("This is a BufferedWriter example.");
            
            System.out.println("Data written successfully!");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}