//Files.move()

import java.io.IOException;
import java.nio.file.*;

public class FileCutExample {
    public static void main(String[] args) {
        Path source = Paths.get("D:\\source.txt");
        Path tempDir = Paths.get("D:\\temp\\");
        
        try {
            // Create temp directory if it doesn't exist
            if (!Files.exists(tempDir)) {
                Files.createDirectory(tempDir);
            }
            
            // Cut (move) the file to temp location
            Path tempLocation = tempDir.resolve(source.getFileName());
            Files.move(source, tempLocation, 
                     StandardCopyOption.REPLACE_EXISTING);
            
            System.out.println("File cut successfully to: " + tempLocation);
        } catch (IOException e) {
            System.err.println("Error cutting file: " + e.getMessage());
        }
    }
}